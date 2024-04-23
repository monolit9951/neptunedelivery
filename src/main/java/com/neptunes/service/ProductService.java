package com.neptunes.service;


import com.neptunes.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Page<Product> getAllProducts( Pageable pageable, Long categoryId );

    Product getProductById( Long productId );
}
