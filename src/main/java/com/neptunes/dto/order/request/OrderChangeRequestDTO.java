package com.neptunes.dto.order.request;

import com.neptunes.enums.DeliveryType;
import com.neptunes.enums.PaymentType;
import com.neptunes.enums.StatusType;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class OrderChangeRequestDTO {

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
}
