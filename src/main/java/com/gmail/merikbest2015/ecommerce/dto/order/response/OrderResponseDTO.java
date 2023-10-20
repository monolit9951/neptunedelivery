package com.gmail.merikbest2015.ecommerce.dto.order.response;

import com.gmail.merikbest2015.ecommerce.dto.order.request.ClientInfo;
import com.gmail.merikbest2015.ecommerce.dto.order.request.DeliveryAddress;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
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
}