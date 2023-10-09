package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import com.gmail.merikbest2015.ecommerce.repository.OrderRepository;
import com.gmail.merikbest2015.ecommerce.repository.projection.OrderProjection;
import com.gmail.merikbest2015.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
//    private final OrderItemRepository orderItemRepository;
//    private final MailSender mailSender;

//    @Override
//    public OldOrder getOrderById(Long orderId) {
//        return orderRepository.findById(orderId)
//                .orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
//    }

//    @Override
//    public List<OldOrderItem> getOrderItemsByOrderId(Long orderId) {
//        OldOrder oldOrder = getOrderById(orderId);
//        return oldOrder.getOldOrderItems();
//    }
//
    @Override
    public Page<OrderProjection> getAllOrders(Pageable pageable) {
        return orderRepository.findAllByOrderByIdAsc(pageable);
    }


    @Override
    @Transactional
    public Order postOrder( Order order ) {
        //order.setS
        Order savedOrder = orderRepository.save( order );
        return savedOrder;
    }

    @Override
    public void updateOrderStatus(Long statusId, StatusType statusType) {
        Optional<Order> optionalOrder = orderRepository.findById(statusId); //нэиминг поменять

        if(optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatusType(statusType);
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException();
        }
    }


//    @Override
//    public Page<OldOrder> getUserOrders(String email, Pageable pageable) {
//        return orderRepository.findOrderByEmail(email, pageable);
//    }
//
//    @Override
//    @Transactional
//    public Order postOrder(Order order, Map<Long, Long> perfumesId) {
//        List<OrderItem> orderItemList = new ArrayList<>();
//
//        for (Map.Entry<Long, Long> entry : perfumesId.entrySet()) {
//            Perfume perfume = perfumeRepository.findById(entry.getKey()).get();
//            OrderItem orderItem = new OrderItem();
//            orderItem.setPerfume(perfume);
//            orderItem.setAmount((perfume.getPrice() * entry.getValue()));
//            orderItem.setQuantity(entry.getValue());
//            orderItemList.add(orderItem);
//            orderItemRepository.save(orderItem);
//        }
//        order.getOrderItems().addAll(orderItemList);
//        orderRepository.save(order);
//
//        String subject = "Order #" + order.getId();
//        String template = "order-template";
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put("order", order);
////        mailSender.sendMessageHtml(order.getEmail(), subject, template, attributes);
//        return order;
//    }

//    @Override
//    @Transactional
//    public String deleteOrder(Long orderId) {
//        OldOrder oldOrder = orderRepository.findById(orderId)
//                .orElseThrow(() -> new ApiRequestException(ORDER_NOT_FOUND, HttpStatus.NOT_FOUND));
//        orderRepository.delete( oldOrder );
//        return "Order deleted successfully";
//    }
//
//    @Override
//    public DataFetcher<List<OldOrder>> getAllOrdersByQuery() {
//        return dataFetchingEnvironment -> orderRepository.findAllByOrderByIdAsc();
//    }

//    @Override
//    public DataFetcher<List<OldOrder>> getUserOrdersByEmailQuery() {
//        return dataFetchingEnvironment -> {
//            String email = dataFetchingEnvironment.getArgument("email").toString();
//            return orderRepository.findOrderByEmail(email);
//        };
//    }
}
