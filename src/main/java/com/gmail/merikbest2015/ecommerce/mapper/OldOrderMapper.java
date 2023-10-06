package com.gmail.merikbest2015.ecommerce.mapper;

//import com.gmail.merikbest2015.ecommerce.domain.old.OldOrder;
import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.order.old.OldOrderItemResponse;
import com.gmail.merikbest2015.ecommerce.dto.order.old.OldOrderRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.old.OldOrderResponse;
import com.gmail.merikbest2015.ecommerce.exception.InputFieldException;
import com.gmail.merikbest2015.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.List;

//@Component
//@RequiredArgsConstructor
//public class OldOrderMapper {
//
//    private final CommonMapper commonMapper;
//    private final OrderService orderService;
//
//    public OldOrderResponse getOrderById(Long orderId) {
//        return commonMapper.convertToResponse(orderService.getOrderById(orderId), OldOrderResponse.class);
//    }
//
//    public List<OldOrderItemResponse> getOrderItemsByOrderId(Long orderId) {
//        return commonMapper.convertToResponseList(orderService.getOrderItemsByOrderId(orderId), OldOrderItemResponse.class);
//    }
//
//    public HeaderResponse<OldOrderResponse> getAllOrders(Pageable pageable) {
//        Page<OldOrder> orders = orderService.getAllOrders(pageable);
//        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OldOrderResponse.class);
//    }
//
//    public HeaderResponse<OldOrderResponse> getUserOrders(String email, Pageable pageable) {
//        Page<OldOrder> orders = orderService.getUserOrders(email, pageable);
//        return commonMapper.getHeaderResponse(orders.getContent(), orders.getTotalPages(), orders.getTotalElements(), OldOrderResponse.class);
//    }
//
//    public String deleteOrder(Long orderId) {
//        return orderService.deleteOrder(orderId);
//    }
//
//    public OldOrderResponse postOrder( OldOrderRequest oldOrderRequest, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        }
//        OldOrder oldOrder = orderService.postOrder(commonMapper.convertToEntity( oldOrderRequest, OldOrder.class), oldOrderRequest.getPerfumesId());
//        return commonMapper.convertToResponse( oldOrder, OldOrderResponse.class);
//    }
//}
