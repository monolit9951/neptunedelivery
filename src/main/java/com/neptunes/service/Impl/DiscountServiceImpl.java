package com.neptunes.service.Impl;

import com.neptunes.domain.Category;
import com.neptunes.domain.Discount;
import com.neptunes.domain.Product;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.repository.CategoryRepository;
import com.neptunes.repository.DiscountRepository;
import com.neptunes.repository.ProductRepository;
import com.neptunes.service.DiscountService;
import com.neptunes.enums.DiscountType;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.neptunes.constants.ErrorMessage.*;


@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Discount createDiscount(Discount discount) {
        switch(discount.getDiscountType()){
            case PRODUCT:
                Product product = productRepository.findById(discount.getRelationId()).orElseThrow(()->
                        new ApiRequestException(PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND));
                product.setDiscount(discount);
                discount = discountRepository.save(discount);
                productRepository.save(product);
                return discount;
            case CATEGORY:
                Category category = categoryRepository.findById(discount.getRelationId()).orElseThrow(()->
                        new ApiRequestException(CATEGORY_NOT_FOUND, HttpStatus.NOT_FOUND));
                category.setDiscount(discount);
                discount = discountRepository.save(discount);
                categoryRepository.save(category);
                return discount;
            default:
                throw new ApiRequestException(DISCOUNT_TYPE_NOT_EXIST, HttpStatus.NOT_FOUND);
        }
    }
}
