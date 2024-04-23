package com.neptunes.service.Impl;

import com.neptunes.domain.Product;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.repository.ProductRepository;
import com.neptunes.service.CategoryService;
import com.neptunes.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.neptunes.constants.ErrorMessage.CATEGORY_NOT_FOUND;
import static com.neptunes.constants.ErrorMessage.PRODUCT_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;


    @Override
    public Page<Product> getAllProducts(Pageable pageable, Long categoryId) {

        if(categoryId == null) {
            return productRepository.findAllByOrderByIdAsc(pageable);
        }

        if (categoryService.isCategoryExists(categoryId)) {
            return productRepository.findAllByCategoryIdOrderByIdAsc(pageable, categoryId);
        }

        throw new ApiRequestException(CATEGORY_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ApiRequestException(PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND));
    }
}
