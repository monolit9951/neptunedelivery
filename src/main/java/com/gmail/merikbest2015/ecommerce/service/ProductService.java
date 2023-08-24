package com.gmail.merikbest2015.ecommerce.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;


public interface ProductService {
    Page<ProductProjection> getAllProducts( Pageable pageable );


    Product getProductById( Long perfumeId );
}
