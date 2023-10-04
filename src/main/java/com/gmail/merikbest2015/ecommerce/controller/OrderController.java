package com.gmail.merikbest2015.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.response.OrderResponse;

import com.gmail.merikbest2015.ecommerce.mapper.OrderMapper;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderMapper orderMapper;


//    @GetMapping(ORDER_ID)
//    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long orderId) {
//        return ResponseEntity.ok( oldOrderMapper.getOrderById(orderId));
//    } admin func

//    @GetMapping(ORDER_ID_ITEMS)
//    public ResponseEntity<List<OrderItemResponse>> getOrderItemsByOrderId(@PathVariable Long orderId) {
//        return ResponseEntity.ok( oldOrderMapper.getOrderItemsByOrderId(orderId));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<OrderResponse>> getUserOrders(@AuthenticationPrincipal UserPrincipal user,
//                                                             @PageableDefault(size = 10) Pageable pageable) {
//        HeaderResponse<OrderResponse> response = oldOrderMapper.getUserOrders(user.getEmail(), pageable);
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }

    @PostMapping
    public ResponseEntity<OrderResponse> postOrder(@Valid @RequestBody OrderRequest order, BindingResult bindingResult) {
        return ResponseEntity.ok( orderMapper.postOrder(order, bindingResult));
    }

//    @PostMapping(GRAPHQL)
//    public ResponseEntity<ExecutionResult> getUserOrdersByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }
}
