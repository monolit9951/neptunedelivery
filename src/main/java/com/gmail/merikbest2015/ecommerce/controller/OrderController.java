package com.gmail.merikbest2015.ecommerce.controller;

import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.StatusTypeRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderRequest;
import com.gmail.merikbest2015.ecommerce.dto.order.response.OrderResponse;
import com.gmail.merikbest2015.ecommerce.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getUsersOrders(@PageableDefault(size = 15) Pageable pageable) {
        HeaderResponse<OrderResponse> response = orderMapper.getAllOrders(pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }


    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest order, BindingResult bindingResult) {
        return ResponseEntity.ok(orderMapper.createOrder(order, bindingResult));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable Long orderId, @RequestBody StatusTypeRequest statusType) {
        OrderResponse response = orderMapper.updateOrderStatus(orderId, statusType.getStatusType());
        return ResponseEntity.ok(response);

    }

//    @PostMapping(GRAPHQL)
//    public ResponseEntity<ExecutionResult> getUserOrdersByQuery(@RequestBody GraphQLRequest request) {
//        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
//    }

}
