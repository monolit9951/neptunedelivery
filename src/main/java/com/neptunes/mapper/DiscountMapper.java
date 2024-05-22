package com.neptunes.mapper;

import com.neptunes.domain.Discount;
import com.neptunes.dto.discounts.request.DiscountRequest;
import com.neptunes.dto.discounts.response.DiscountResponseDTO;
import com.neptunes.service.DiscountService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountMapper {

    private final CommonMapper commonMapper;

    private final DiscountService discountService;
    public DiscountResponseDTO createDiscount( DiscountRequest request) {
        Discount discount = Discount.builder()
                .discountPerQuantity(request.getDiscountPerQuantity())
                .discountType(request.getDiscountType())
                .relationId(request.getRelationId()).build();
        return commonMapper.convertToResponse(discountService.createDiscount(discount), DiscountResponseDTO.class);
    }
}
