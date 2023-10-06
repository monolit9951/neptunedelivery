package com.gmail.merikbest2015.ecommerce.repository.projection;

import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;

import java.time.Instant;
import java.util.List;


public interface OrderProjection {

    Long getId();

    Instant getToDate();

    Instant getToTime();

    String getFirstName();

    String getPhoneNumber();

    Long getCityId();

    String getStreet();

    String getHouseNumber();

    String getHouseEntrance();

    String getHouseFloor();

    String getApartmentNumber();

    Integer getPostIndex();

    String getComment();

    Integer getPeopleQuantity();

    List<OrderCartItem> getCartItems();

    Integer getStudyQuantity();

    Integer getSimpleQuantity();

    DeliveryType getDeliveryType();

    PaymentType getPaymentType();

    StatusType getStatusType();
}
