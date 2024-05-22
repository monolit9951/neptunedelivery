package com.neptunes.dto.discounts.response;

import com.neptunes.enums.DiscountType;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class DiscountResponseDTO {

    private Map<String, BigDecimal> discountPerQuantity;

    private DiscountType discountType;

    private Long relationId;
}
