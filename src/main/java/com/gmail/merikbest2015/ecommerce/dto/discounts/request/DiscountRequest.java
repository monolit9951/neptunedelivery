package com.gmail.merikbest2015.ecommerce.dto.discounts.request;

import com.gmail.merikbest2015.ecommerce.enums.DiscountType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class DiscountRequest {

    private Map<String, BigDecimal> discountPerQuantity;
    private Long relationId;
    private DiscountType type;
}
