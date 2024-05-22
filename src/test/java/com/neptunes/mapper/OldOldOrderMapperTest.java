package com.neptunes.mapper;

//import com.gmail.merikbest2015.ecommerce.domain.old.OldOrder;
import com.neptunes.dto.order.old.OldOrderRequest;
import com.neptunes.util.TestConstants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OldOldOrderMapperTest {

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void convertToEntity() {
        OldOrderRequest oldOrderRequest = new OldOrderRequest();
        oldOrderRequest.setFirstName( TestConstants.FIRST_NAME);
        oldOrderRequest.setLastName( TestConstants.LAST_NAME);
        oldOrderRequest.setCity( TestConstants.CITY);
        oldOrderRequest.setAddress( TestConstants.ADDRESS);
        oldOrderRequest.setEmail( TestConstants.ORDER_EMAIL);
        oldOrderRequest.setPostIndex( TestConstants.POST_INDEX);
        oldOrderRequest.setPhoneNumber( TestConstants.PHONE_NUMBER);
        oldOrderRequest.setTotalPrice( TestConstants.TOTAL_PRICE);

//        OldOrder oldOrder = modelMapper.map( oldOrderRequest, OldOrder.class);
//        assertEquals( oldOrderRequest.getFirstName(), oldOrder.getFirstName());
//        assertEquals( oldOrderRequest.getLastName(), oldOrder.getLastName());
//        assertEquals( oldOrderRequest.getAddress(), oldOrder.getAddress());
//        assertEquals( oldOrderRequest.getCity(), oldOrder.getCity());
//        assertEquals( oldOrderRequest.getEmail(), oldOrder.getEmail());
//        assertEquals( oldOrderRequest.getPostIndex(), oldOrder.getPostIndex());
//        assertEquals( oldOrderRequest.getPhoneNumber(), oldOrder.getPhoneNumber());
//        assertEquals( oldOrderRequest.getTotalPrice(), oldOrder.getTotalPrice());
    }

    @Test
    public void convertToResponseDto() {
//        OldOrder oldOrder = new OldOrder();
//        oldOrder.setId(1L);
//        oldOrder.setFirstName(FIRST_NAME);
//        oldOrder.setLastName(LAST_NAME);
//        oldOrder.setCity(CITY);
//        oldOrder.setAddress(ADDRESS);
//        oldOrder.setEmail(ORDER_EMAIL);
//        oldOrder.setPostIndex(POST_INDEX);
//        oldOrder.setPhoneNumber(PHONE_NUMBER);
//        oldOrder.setTotalPrice(TOTAL_PRICE);
//
//        OldOrderResponse oldOrderResponse = modelMapper.map( oldOrder, OldOrderResponse.class);
//        assertEquals( oldOrder.getId(), oldOrderResponse.getId());
//        assertEquals( oldOrder.getFirstName(), oldOrderResponse.getFirstName());
//        assertEquals( oldOrder.getLastName(), oldOrderResponse.getLastName());
//        assertEquals( oldOrder.getAddress(), oldOrderResponse.getAddress());
//        assertEquals( oldOrder.getCity(), oldOrderResponse.getCity());
//        assertEquals( oldOrder.getEmail(), oldOrderResponse.getEmail());
//        assertEquals( oldOrder.getPostIndex(), oldOrderResponse.getPostIndex());
//        assertEquals( oldOrder.getPhoneNumber(), oldOrderResponse.getPhoneNumber());
//        assertEquals( oldOrder.getTotalPrice(), oldOrderResponse.getTotalPrice());
    }
}
