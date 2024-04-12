package com.gmail.merikbest2015.ecommerce.dto.discounts.response;

import com.gmail.merikbest2015.ecommerce.enums.DiscountType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class DiscountResponseDTO {

    private Map<String, BigDecimal> discountPerQuantity;

    private DiscountType discountType;

    private Long relationId;
}
