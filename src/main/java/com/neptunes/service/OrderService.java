package com.neptunes.service;

import com.neptunes.domain.Order;
import com.neptunes.enums.StatusType;
import com.neptunes.repository.projection.OrderProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
//
//    OldOrder getOrderById(Long orderId);
//
//    List<OldOrderItem> getOrderItemsByOrderId(Long orderId);
//
    Page<OrderProjection> getAllOrders(Pageable pageable);

    Order createOrder(Order order );

    Order updateOrderStatus(Long statusId, StatusType statusType);

    Order changeOrderFull(Long orderId, Order order);


//    String deleteOrder(Long orderId);
//
//    DataFetcher<List<OldOrder>> getAllOrdersByQuery();
}
