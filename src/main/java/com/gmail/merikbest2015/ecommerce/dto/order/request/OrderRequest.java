package com.gmail.merikbest2015.ecommerce.dto.order.request;

import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
public class OrderRequest {
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
}
