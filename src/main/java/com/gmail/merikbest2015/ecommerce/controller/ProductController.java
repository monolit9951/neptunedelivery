package com.gmail.merikbest2015.ecommerce.controller;

import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.products.response.FullProductResponse;
import com.gmail.merikbest2015.ecommerce.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/products" )
public class ProductController {
    private final ProductMapper productMapper;


    @GetMapping
    public ResponseEntity<List<FullProductResponse>> getAllProducts( @PageableDefault( size = 15 ) Pageable pageable ) {
        HeaderResponse<FullProductResponse> response = productMapper.getAllProducts( pageable );
        return ResponseEntity.ok().headers( response.getHeaders() ).body( response.getItems() );
    }


    @GetMapping( "/{productId}" )
    public ResponseEntity<FullProductResponse> getProductById( @PathVariable Long productId ) {
        return ResponseEntity.ok( productMapper.getProductById( productId ) );
    }
}
