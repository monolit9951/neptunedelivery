package com.gmail.merikbest2015.ecommerce.repository.projection;

import com.gmail.merikbest2015.ecommerce.dto.order.request.ClientInfo;
import com.gmail.merikbest2015.ecommerce.dto.order.request.DeliveryAddress;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;

import java.time.Instant;
import java.util.List;


public interface OrderProjection {

    Long getId();

    Instant getToDateTime();

    ClientInfo getClientInfo();

    DeliveryAddress getDeliveryAddress();

    String getComment();

    Integer getPeopleCount();

    List<OrderCartItem> getCartItems();

    Integer getSticksCount();

    Integer getStudySticksCount();

    DeliveryType getDeliveryType();

    PaymentType getPaymentType();

    StatusType getStatusType();
}
