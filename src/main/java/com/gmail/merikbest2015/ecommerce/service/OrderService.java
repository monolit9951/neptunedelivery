package com.gmail.merikbest2015.ecommerce.service;

import com.gmail.merikbest2015.ecommerce.domain.Order;

import graphql.schema.DataFetcher;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
//
//    OldOrder getOrderById(Long orderId);
//
//    List<OldOrderItem> getOrderItemsByOrderId(Long orderId);
//
//    Page<OldOrder> getAllOrders(Pageable pageable);


    Order postOrder( Order order );

//    String deleteOrder(Long orderId);
//
//    DataFetcher<List<OldOrder>> getAllOrdersByQuery();
}
