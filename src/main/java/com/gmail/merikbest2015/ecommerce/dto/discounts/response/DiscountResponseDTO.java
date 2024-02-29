package com.gmail.merikbest2015.ecommerce.dto.discounts.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class DiscountResponseDTO {

    private Map<String, BigDecimal> discountPerQuantity;
}
