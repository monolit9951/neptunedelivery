package com.gmail.merikbest2015.ecommerce.service;


import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Page<ProductProjection> getAllProducts( Pageable pageable, Long categoryId );

    Product getProductById( Long productId );

    Product updateProductImg(Long productId, String img);
}
