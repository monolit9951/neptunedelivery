package com.gmail.merikbest2015.ecommerce.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.products.response.FullProductResponse;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import com.gmail.merikbest2015.ecommerce.service.ProductService;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CommonMapper commonMapper;

    private final ProductService productService;


    public HeaderResponse<FullProductResponse> getAllProducts( Pageable pageable ) {
        Page<ProductProjection> products = productService.getAllProducts( pageable );
        return commonMapper.getHeaderResponse( products.getContent(), products.getTotalPages(),
                products.getTotalElements(), FullProductResponse.class );
    }


    public FullProductResponse getProductById( Long productId ) {
        return commonMapper.convertToResponse( productService.getProductById( productId ), FullProductResponse.class );
    }
}
