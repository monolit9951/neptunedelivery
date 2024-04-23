package com.neptunes.dto.order.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryAddress implements Serializable {
    private String clientAddress;
}
