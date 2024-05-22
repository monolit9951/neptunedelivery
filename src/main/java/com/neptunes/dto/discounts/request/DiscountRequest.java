package com.neptunes.dto.discounts.request;

import com.neptunes.enums.DiscountType;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class DiscountRequest {

    private Map<Long, BigDecimal> discountPerQuantity;
    private Long relationId;
    private DiscountType discountType;
}
