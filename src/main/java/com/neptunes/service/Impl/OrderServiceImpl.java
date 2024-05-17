package com.neptunes.service.Impl;

import com.neptunes.constants.ErrorMessage;
import com.neptunes.domain.Discount;
import com.neptunes.domain.Order;
import com.neptunes.domain.Product;
import com.neptunes.domain.Voucher;
import com.neptunes.dto.order.request.OrderCartItem;
import com.neptunes.dto.order.request.OrderRequest;
import com.neptunes.dto.order.response.OrderResponseDTO;
import com.neptunes.enums.PaymentType;
import com.neptunes.enums.StatusType;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.mapper.CommonMapper;
import com.neptunes.repository.OrderRepository;
import com.neptunes.repository.ProductRepository;
import com.neptunes.repository.VoucherRepository;
import com.neptunes.repository.projection.OrderProjection;
import com.neptunes.service.OrderService;

import com.neptunes.service.VoucherService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.neptunes.constants.ErrorMessage.VOUCHER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final VoucherService voucherService;
    private final static String CURRENCY = "pln";
    private final CommonMapper commonMapper;
//    private final OrderItemRepository orderItemRepository;
//    private final MailSender mailSender;

//    @Override
//    public OldOrder getOrderById(Long orderId) {
//        return orderRepository.findById(orderId)
//                .orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
//    }

    //    @Override
//    public List<OldOrderItem> getOrderItemsByOrderId(Long orderId) {
//        OldOrder oldOrder = getOrderById(orderId);
//        return oldOrder.getOldOrderItems();
//    }
//
    @Override
    public Page<OrderProjection> getAllOrders(Pageable pageable) {
        return orderRepository.findAllByOrderByIdAsc(pageable);
    }

    @Transactional
    @Override
    public OrderResponseDTO createOrder(OrderRequest orderRequest) throws StripeException {
        BigDecimal totalSum = totalSumOrder(orderRequest.getCartItems());
        String voucherCode = orderRequest.getCode();
        if(voucherCode != null && !voucherCode.isEmpty()){
            Voucher voucher = voucherService.validateVoucher(voucherCode);
            BigDecimal discountPercentage = voucher.getDiscountPercentage();
            totalSum = totalSum.multiply(discountPercentage);
            voucherService.activateVoucher(voucherCode);
        }
        Order order = commonMapper.convertToEntity(orderRequest, Order.class);
        order.setTotalSum(totalSum);
        System.out.println(totalSum);
        order.setStatusType( StatusType.CREATED);
        Order savedOrder = orderRepository.save(order);
        OrderResponseDTO orderResponseDTO = commonMapper.convertToResponse(savedOrder, OrderResponseDTO.class);
        if(savedOrder.getPaymentType().equals(PaymentType.ONLINE)){
            Session paymentSession = createPaymentSession(order);
            orderResponseDTO.setUrlForPayment(paymentSession.getUrl());
        }
        return orderResponseDTO ;
    }

    @Transactional
    @Override
    public Order updateOrderStatus(Long orderId, StatusType statusType) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST));

        order.setStatusType(statusType);
        return orderRepository.save(order);

    }

    @Override
    public Order changeOrderFull(Long orderId, Order order) {

        if (orderRepository.isOrderExists(orderId)) {
            order.setId(orderId);
            return orderRepository.save(order);
        }

        throw new ApiRequestException(ErrorMessage.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }

    private BigDecimal totalSumOrder(List<OrderCartItem> cartItems) {
        BigDecimal sumOrder = BigDecimal.ZERO;

        for (OrderCartItem orderCartItem : cartItems) {
            Product product = productRepository.findById(orderCartItem.getId())
                    .orElseThrow(() -> new NoSuchElementException("Can't found product by id: " + orderCartItem.getId()));

            long quantity = orderCartItem.getQuantity();
            Discount productDiscount = product.getDiscount();
            BigDecimal discount = BigDecimal.ZERO;
            if (productDiscount != null) {
                Map<Long, BigDecimal> discountPerQuantity = productDiscount.getDiscountPerQuantity();
                for (Map.Entry<Long, BigDecimal> entry : discountPerQuantity.entrySet()) {
                    if (quantity >= entry.getKey()) {
                        discount = entry.getValue();
                    }
                }
            }

            BigDecimal price = product.getPrice();
            BigDecimal discountAmount = price.multiply(discount);
            if (!BigDecimal.ZERO.equals(discount)) {
                sumOrder = sumOrder.add(price.subtract(discountAmount).multiply(BigDecimal.valueOf(quantity)));
            } else {
                sumOrder = sumOrder.add(price.multiply(BigDecimal.valueOf(quantity)));
            }
        }

        return sumOrder;
    }

    private Session createPaymentSession(Order order) throws StripeException {
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();

        for (OrderCartItem orderCartItem : order.getCartItems()) {
            Product product = productRepository.findById(orderCartItem.getId())
                    .orElseThrow(() -> new NoSuchElementException("Can't find product by id: " + orderCartItem.getId()));

            String productName = product.getName(); // Назва продукту
            BigDecimal price = product.getPrice(); // Ціна продукту
            long quantity = orderCartItem.getQuantity(); // Кількість продукту

            lineItems.add(
                    SessionCreateParams.LineItem.builder()
                            .setPriceData(
                                    SessionCreateParams.LineItem.PriceData.builder()
                                            .setCurrency(CURRENCY)
                                            .setUnitAmount(convertPLNToGrosze(price))
                                            .setProductData(
                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                            .setName(productName)
                                                            .build()
                                            )
                                            .build()
                            )
                            .setQuantity(quantity)
                            .build()
            );
        }

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .addAllLineItem(lineItems)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("http://localhost:3000/success")
                .setCancelUrl("http://localhost:3000/cancel")
                .build();

        Session session = Session.create(params);

        String paymentIntentId = session.getPaymentIntent();

        order.setStripeOrderId(paymentIntentId);
        order.setStatusType(StatusType.CREATED_NOT_PAID);
        changeOrderFull(order.getId(), order);

        return session;
    }

    private long convertPLNToGrosze(BigDecimal amountInPLN) {
        BigDecimal groszeBigDecimal = amountInPLN.multiply(BigDecimal.valueOf(100));
        return groszeBigDecimal.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }

//    @Override
//    public Page<OldOrder> getUserOrders(String email, Pageable pageable) {
//        return orderRepository.findOrderByEmail(email, pageable);
//    }
//
//    @Override
//    @Transactional
//    public Order postOrder(Order order, Map<Long, Long> perfumesId) {
//        List<OrderItem> orderItemList = new ArrayList<>();
//
//        for (Map.Entry<Long, Long> entry : perfumesId.entrySet()) {
//            Perfume perfume = perfumeRepository.findById(entry.getKey()).get();
//            OrderItem orderItem = new OrderItem();
//            orderItem.setPerfume(perfume);
//            orderItem.setAmount((perfume.getPrice() * entry.getValue()));
//            orderItem.setQuantity(entry.getValue());
//            orderItemList.add(orderItem);
//            orderItemRepository.save(orderItem);
//        }
//        order.getOrderItems().addAll(orderItemList);
//        orderRepository.save(order);
//
//        String subject = "Order #" + order.getId();
//        String template = "order-template";
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put("order", order);
////        mailSender.sendMessageHtml(order.getEmail(), subject, template, attributes);
//        return order;
//    }

//    @Override
//    @Transactional
//    public String deleteOrder(Long orderId) {
//        OldOrder oldOrder = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
//        orderRepository.delete( oldOrder );
//        return "Order deleted successfully";
//    }
//
//    @Override
//    public DataFetcher<List<OldOrder>> getAllOrdersByQuery() {
//        return dataFetchingEnvironment -> orderRepository.findAllByOrderByIdAsc();
//    }

//    @Override
//    public DataFetcher<List<OldOrder>> getUserOrdersByEmailQuery() {
//        return dataFetchingEnvironment -> {
//            String email = dataFetchingEnvironment.getArgument("email").toString();
//            return orderRepository.findOrderByEmail(email);
//        };
//    }
}
