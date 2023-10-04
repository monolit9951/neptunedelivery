package com.gmail.merikbest2015.ecommerce.mapper;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.response.OrderResponse;
import com.gmail.merikbest2015.ecommerce.exception.InputFieldException;
import com.gmail.merikbest2015.ecommerce.service.OrderService;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final CommonMapper commonMapper;
    private final OrderService orderService;

//    public OldOrderResponse getOrderById(Long orderId) {
//        return commonMapper.convertToResponse(orderService.getOrderById(orderId), OldOrderResponse.class);
//    }
//
//    public List<OldOrderItemResponse> getOrderItemsByOrderId(Long orderId) {
//        return commonMapper.convertToResponseList(orderService.getOrderItemsByOrderId(orderId), OldOrderItemResponse.class);
//    }
//
//    public HeaderResponse<OldOrderResponse> getAllOrders( Pageable pageable) {
//        Page<OldOrder> orders = orderService.getAllOrders(pageable);
//        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OldOrderResponse.class);
//    }

//    public String deleteOrder(Long orderId) {
//        return orderService.deleteOrder(orderId);
//    }

    public OrderResponse postOrder( OrderRequest orderRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        Order order = orderService.postOrder(commonMapper.convertToEntity( orderRequest, Order.class));
        return commonMapper.convertToResponse( order, OrderResponse.class);
    }
}
