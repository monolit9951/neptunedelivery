package com.neptunes.dto.order.response;

import com.neptunes.dto.order.request.ClientInfo;
import com.neptunes.dto.order.request.DeliveryAddress;
import com.neptunes.dto.order.request.OrderCartItem;
import com.neptunes.enums.DeliveryType;
import com.neptunes.enums.PaymentType;
import com.neptunes.enums.StatusType;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;


@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private Instant toDateTime;
    private ClientInfo clientInfo;
    private DeliveryAddress deliveryAddress;
    private String comment;
    private Integer peopleCount;
    private List<OrderCartItem> cartItems;
    private Integer sticksCount;
    private Integer studySticksCount;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private StatusType statusType;
    private String code;
    private String urlForPayment;
}