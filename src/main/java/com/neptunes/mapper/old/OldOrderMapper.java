package com.neptunes.mapper.old;

//import com.gmail.merikbest2015.ecommerce.domain.old.OldOrder;


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
