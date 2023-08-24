package com.gmail.merikbest2015.ecommerce.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.ProductRepository;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import com.gmail.merikbest2015.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.PRODUCT_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public Page<ProductProjection> getAllProducts( Pageable pageable ) {
        return productRepository.findAllByOrderByIdAsc( pageable );
    }


    @Override
    public Product getProductById( Long productId ) {
        return productRepository.findById( productId )
                .orElseThrow( () -> new ApiRequestException( PRODUCT_NOT_FOUND, HttpStatus.NOT_FOUND ) );
    }
}
