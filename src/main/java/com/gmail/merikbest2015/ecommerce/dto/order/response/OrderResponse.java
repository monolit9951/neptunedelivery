package com.gmail.merikbest2015.ecommerce.dto.order.response;

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
public class OrderResponse {
    private Long id;
    private Instant toDate;
    private Instant toTime;
    private String firstName;
    private String phoneNumber;
    private Long cityId;
    private String street;
    private String houseNumber;
    private String houseEntrance;
    private String houseFloor;
    private String apartmentNumber;
    private Integer postIndex;
    private String comment;
    private Integer peopleQuantity;
    private List<OrderCartItem> cartItems;
    private Integer studyQuantity;
    private Integer simpleQuantity;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private StatusType statusType;

}