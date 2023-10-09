package com.gmail.merikbest2015.ecommerce.service;

import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import com.gmail.merikbest2015.ecommerce.repository.projection.OrderProjection;
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

//    String deleteOrder(Long orderId);
//
//    DataFetcher<List<OldOrder>> getAllOrdersByQuery();
}
