package com.neptunes.dto.order.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class OrderCartItem implements Serializable {
    private Long id;
    private Long quantity;
}
