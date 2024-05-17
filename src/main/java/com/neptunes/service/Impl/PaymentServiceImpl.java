package com.neptunes.service.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neptunes.constants.ErrorMessage;
import com.neptunes.domain.Order;
import com.neptunes.enums.StatusType;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.exception.JsonProcessingFailureException;
import com.neptunes.exception.PaymentMismatchException;
import com.neptunes.repository.OrderRepository;
import com.neptunes.service.OrderService;
import com.neptunes.service.PaymentService;
import com.neptunes.exception.VerificationException;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    @Value("${stripe.webhook}")
    private String webhookKey;

    @Override
    public PaymentIntent retrievePaymentIntent(String id) throws StripeException {
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Order orderDb = getOrderByPaymentIntentId(id);
        String statusPaid = paymentIntent.getStatus();
        Long amountPaid = paymentIntent.getAmount();
        updateOrderStatusBasedOnPayment(orderDb, statusPaid, amountPaid);
        return PaymentIntent.retrieve(id);
    }

    @Override
    public void processStripeWebhook(String payload, String sigHeader) {
        Event event;
        try {
            event = Webhook.constructEvent(payload, sigHeader, webhookKey);
        } catch (SignatureVerificationException e) {
            throw new VerificationException("Failed signature verification!");
        }

        EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
        String paymentIntentId = getPaymentIntentId(dataObjectDeserializer);

        Order orderDb = getOrderByPaymentIntentId(paymentIntentId);

        switch (event.getType()) {
            case "payment_intent.succeeded":
                orderService.updateOrderStatus(orderDb.getId(), StatusType.CREATED_PAID);
                break;
            default:
                orderService.updateOrderStatus(orderDb.getId(), StatusType.CREATED_NOT_PAID);
        }
    }

    private BigDecimal convertGroszeToPLN(long amountInGrosze) {
        BigDecimal amountInPLN = BigDecimal.valueOf(amountInGrosze).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
        return amountInPLN;
    }

    private Order getOrderByPaymentIntentId(String paymentIntentId) {
        return orderRepository.findByStripeOrderId(paymentIntentId)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST));
    }

    private void updateOrderStatusBasedOnPayment(Order orderDb, String statusPaid, long amountPaid) {
        if ("succeeded".equalsIgnoreCase(statusPaid)) {
            BigDecimal totalSumOrder = orderDb.getTotalSum();
            BigDecimal paid = convertGroszeToPLN(amountPaid);
            if (totalSumOrder.equals(paid)) {
                orderService.updateOrderStatus(orderDb.getId(), StatusType.CREATED_PAID);
            } else {
                throw new PaymentMismatchException("The paid amount does not match the total order amount. Sum order = " + totalSumOrder + ". Sum paid = " + paid);
            }
        } else {
            orderService.updateOrderStatus(orderDb.getId(), StatusType.CREATED_NOT_PAID);
        }
    }

    private String getPaymentIntentId(EventDataObjectDeserializer dataObjectDeserializer) {
        String rawJson = dataObjectDeserializer.getRawJson();
        String paymentIntentId;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(rawJson);
            paymentIntentId = jsonNode.get("id").asText();
        } catch (Exception e) {
            throw new JsonProcessingFailureException("Can't parsing id");
        }
        return paymentIntentId;
    }

}
