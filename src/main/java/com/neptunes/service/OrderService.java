package com.neptunes.service;

import com.neptunes.domain.Order;
import com.neptunes.dto.order.request.OrderRequest;
import com.neptunes.dto.order.response.OrderResponseDTO;
import com.neptunes.enums.StatusType;
import com.neptunes.repository.projection.OrderProjection;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
//
//    OldOrder getOrderById(Long orderId);
//
//    List<OldOrderItem> getOrderItemsByOrderId(Long orderId);
//
    Page<OrderProjection> getAllOrders(Pageable pageable);

    OrderResponseDTO createOrder(OrderRequest orderRequest ) throws StripeException;

    Order updateOrderStatus(Long statusId, StatusType statusType);

    Order changeOrderFull(Long orderId, Order order);


//    String deleteOrder(Long orderId);
//
//    DataFetcher<List<OldOrder>> getAllOrdersByQuery();
}
