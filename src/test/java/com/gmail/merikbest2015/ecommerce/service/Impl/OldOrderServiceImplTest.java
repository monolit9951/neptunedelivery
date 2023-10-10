package com.gmail.merikbest2015.ecommerce.service.Impl;

//import com.gmail.merikbest2015.ecommerce.domain.old.OldOrder;
//import com.gmail.merikbest2015.ecommerce.domain.old.OldOrderItem;
//import com.gmail.merikbest2015.ecommerce.domain.Perfume;
//import com.gmail.merikbest2015.ecommerce.repository.OrderItemRepository;
//import com.gmail.merikbest2015.ecommerce.repository.OrderRepository;
//import com.gmail.merikbest2015.ecommerce.repository.PerfumeRepository;
import com.gmail.merikbest2015.ecommerce.service.email.MailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.gmail.merikbest2015.ecommerce.util.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class OldOrderServiceImplTest {
//
//    @Autowired
//    private OrderServiceImpl orderService;
//
//    @MockBean
//    private OrderRepository orderRepository;
//
//    @MockBean
//    private OrderItemRepository orderItemRepository;
//
//    @MockBean
//    private PerfumeRepository perfumeRepository;
//
//    @MockBean
//    private MailSender mailSender;
//
//    @Test
//    public void findAll() {
//        Pageable pageable = PageRequest.of(0, 20);
//        List<OldOrder> oldOrderList = new ArrayList<>();
//        oldOrderList.add(new OldOrder());
//        oldOrderList.add(new OldOrder());
//        Page<OldOrder> orders = new PageImpl<>( oldOrderList, pageable, 20);
//
//        when(orderRepository.findAllByOrderByIdAsc(pageable)).thenReturn(orders);
//        orderService.getAllOrders(pageable);
//        assertEquals(2, oldOrderList.size());
//        verify(orderRepository, times(1)).findAllByOrderByIdAsc(pageable);
//    }
//
//    @Test
//    public void findOrderByEmail() {
//        Pageable pageable = PageRequest.of(0, 20);
//        OldOrder oldOrder1 = new OldOrder();
//        oldOrder1.setEmail(ORDER_EMAIL);
//        OldOrder oldOrder2 = new OldOrder();
//        oldOrder2.setEmail(ORDER_EMAIL);
//        List<OldOrder> oldOrderList = new ArrayList<>();
//        oldOrderList.add( oldOrder1 );
//        oldOrderList.add( oldOrder2 );
//        Page<OldOrder> orders = new PageImpl<>( oldOrderList, pageable, 20);
//
//        when(orderRepository.findOrderByEmail(ORDER_EMAIL, pageable)).thenReturn(orders);
//        orderService.getUserOrders(ORDER_EMAIL, pageable);
//        assertEquals(2, oldOrderList.size());
//        verify(orderRepository, times(1)).findOrderByEmail(ORDER_EMAIL, pageable);
//    }
//
//    @Test
//    public void postOrder() {
//        Map<Long, Long> perfumesId = new HashMap<>();
//        perfumesId.put(1L, 1L);
//        perfumesId.put(2L, 1L);
//
//        Perfume perfume1 = new Perfume();
//        perfume1.setId(1L);
//        perfume1.setPrice(PRICE);
//        Perfume perfume2 = new Perfume();
//        perfume2.setPrice(PRICE);
//        perfume2.setId(2L);
//
//        OldOrderItem oldOrderItem1 = new OldOrderItem();
//        oldOrderItem1.setPerfume(perfume1);
//        oldOrderItem1.setAmount(192L);
//        oldOrderItem1.setQuantity(1L);
//        OldOrderItem oldOrderItem2 = new OldOrderItem();
//        oldOrderItem2.setPerfume(perfume2);
//        oldOrderItem2.setAmount(192L);
//        oldOrderItem2.setQuantity(1L);
//
//        OldOrder oldOrder = new OldOrder();
//        oldOrder.setFirstName(FIRST_NAME);
//        oldOrder.setLastName(LAST_NAME);
//        oldOrder.setCity(CITY);
//        oldOrder.setAddress(ADDRESS);
//        oldOrder.setEmail(ORDER_EMAIL);
//        oldOrder.setPostIndex(POST_INDEX);
//        oldOrder.setPhoneNumber(PHONE_NUMBER);
//        oldOrder.setTotalPrice(TOTAL_PRICE);
//        Map<String, Object> attributes = new HashMap<>();
//        attributes.put("order", oldOrder );
//
//        when(perfumeRepository.findById(1L)).thenReturn(java.util.Optional.of(perfume1));
//        when(perfumeRepository.findById(2L)).thenReturn(java.util.Optional.of(perfume2));
//        when(orderItemRepository.save( oldOrderItem1 )).thenReturn( oldOrderItem1 );
//        when(orderItemRepository.save( oldOrderItem2 )).thenReturn( oldOrderItem2 );
//        when(orderRepository.save( oldOrder )).thenReturn( oldOrder );
//        orderService.postOrder( oldOrder, perfumesId);
//        assertNotNull( oldOrder );
//        assertEquals(ORDER_EMAIL, oldOrder.getEmail());
//        assertNotNull( oldOrderItem1 );
//        assertNotNull( oldOrderItem2 );
//        verify(mailSender, times(1))
//                .sendMessageHtml(
//                        ArgumentMatchers.eq( oldOrder.getEmail()),
//                        ArgumentMatchers.eq("Order #" + oldOrder.getId()),
//                        ArgumentMatchers.eq("order-template"),
//                        ArgumentMatchers.eq(attributes));
//    }
//}
