package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.ProductRepository;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import com.gmail.merikbest2015.ecommerce.service.CategoryService;
import com.gmail.merikbest2015.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.CATEGORY_NOT_FOUND;
import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.PRODUCT_NOT_FOUND;


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
