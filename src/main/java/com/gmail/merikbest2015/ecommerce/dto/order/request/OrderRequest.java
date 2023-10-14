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

//    @Email(message = INCORRECT_EMAIL)
//    @NotBlank(message = EMAIL_CANNOT_BE_EMPTY)
//    private String email;
    private DeliveryAddress address;
    private String comment;
    private Integer peopleQuantity;
    private List<OrderCartItem> cartItems;
    private Integer studyQuantity;
    private Integer simpleQuantity;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
}

/*{
  products: number[] // array of products id
  personCount: number
  sticksCount: number
  paymentType: 'offline' | 'card offline' | 'online'
  deliveryAddress: string // if paymentType === offline
  clientInfo: {
    phoneNumber: string
    name: string
  }
}*/