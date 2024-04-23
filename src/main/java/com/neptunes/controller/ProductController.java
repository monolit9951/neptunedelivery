package com.neptunes.controller;

import com.neptunes.dto.HeaderResponse;
import com.neptunes.dto.products.response.ProductResponseDTO;
import com.neptunes.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(Pageable pageable,
                                                                   @RequestParam(required = false) Long categoryId) { //
        HeaderResponse<ProductResponseDTO> response = productMapper.getAllProducts(pageable, categoryId);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId) {
        return ResponseEntity.ok(productMapper.getProductById(productId));
    }
}
