package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.constants.ErrorMessage;
import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.OrderRepository;
import com.gmail.merikbest2015.ecommerce.repository.ProductRepository;
import com.gmail.merikbest2015.ecommerce.repository.projection.OrderProjection;
import com.gmail.merikbest2015.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
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

    @Transactional
    @Override
    public Order createOrder(Order order) {
        List<OrderCartItem> cartItems = order.getCartItems();
        System.out.println("total order = " + totalSumOrder(cartItems));
        order.setStatusType(StatusType.CREATED);
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public Order updateOrderStatus(Long orderId, StatusType statusType) {
        Order order = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST));

        order.setStatusType(statusType);
        return orderRepository.save(order);

    }

    @Override
    public Order changeOrderFull(Long orderId, Order order) {

        if (orderRepository.isOrderExists(orderId)) {
            order.setId(orderId);
            return orderRepository.save(order);
        }

        throw new ApiRequestException(ErrorMessage.ORDER_NOT_FOUND, HttpStatus.BAD_REQUEST);
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

    private int totalSumOrder(List<OrderCartItem> cartItems) {
        int sumOrder = 0;
        for (OrderCartItem orderCartItem : cartItems) {
            sumOrder += productRepository.findPriceById(orderCartItem.getId()) * orderCartItem.getQuantity();
        }
        return sumOrder;
    }
}
