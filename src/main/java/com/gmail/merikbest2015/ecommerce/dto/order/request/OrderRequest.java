package com.gmail.merikbest2015.ecommerce.dto.order.request;

import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.*;


@Data
public class OrderRequest {
    private Instant toDate;
    private Instant toTime;

    @NotBlank(message = FILL_IN_THE_INPUT_FIELD)
    private String firstName;

    @NotBlank(message = EMPTY_PHONE_NUMBER)
    private String phoneNumber;

//    @Email(message = INCORRECT_EMAIL)
//    @NotBlank(message = EMAIL_CANNOT_BE_EMPTY)
//    private String email;

    private Long cityId;
    private String street;
    private String houseNumber;
    private String houseEntrance;
    private String houseFloor;
    private String apartmentNumber;

    @NotNull(message = EMPTY_POST_INDEX)
    @Min(value = 5, message = "Post index must contain 5 digits")
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
