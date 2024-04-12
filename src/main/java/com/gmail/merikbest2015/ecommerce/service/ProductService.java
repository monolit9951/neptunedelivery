package com.gmail.merikbest2015.ecommerce.service;


import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    Page<Product> getAllProducts( Pageable pageable, Long categoryId );

    Product getProductById( Long productId );
}
