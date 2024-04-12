package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.domain.Discount;
import com.gmail.merikbest2015.ecommerce.dto.discounts.request.DiscountRequest;
import com.gmail.merikbest2015.ecommerce.dto.discounts.response.DiscountResponseDTO;
import com.gmail.merikbest2015.ecommerce.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountMapper {

    private final CommonMapper commonMapper;

    private final DiscountService discountService;
    public DiscountResponseDTO createDiscount(DiscountRequest request) {
        Discount discount = Discount.builder()
                .discountPerQuantity(request.getDiscountPerQuantity())
                .discountType(request.getDiscountType())
                .relationId(request.getRelationId()).build();
        return commonMapper.convertToResponse(discountService.createDiscount(discount), DiscountResponseDTO.class);
    }
}
