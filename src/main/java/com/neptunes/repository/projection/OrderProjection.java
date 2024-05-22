package com.neptunes.repository.projection;

import com.neptunes.dto.order.request.ClientInfo;
import com.neptunes.dto.order.request.DeliveryAddress;
import com.neptunes.dto.order.request.OrderCartItem;
import com.neptunes.enums.DeliveryType;
import com.neptunes.enums.PaymentType;
import com.neptunes.enums.StatusType;

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
