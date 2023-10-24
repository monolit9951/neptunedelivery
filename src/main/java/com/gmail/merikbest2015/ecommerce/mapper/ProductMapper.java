package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.products.response.ProductResponseDTO;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;
import com.gmail.merikbest2015.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final CommonMapper commonMapper;

    private final ProductService productService;


    public HeaderResponse<ProductResponseDTO> getAllProducts(Pageable pageable, Long categoryId) {
        Page<ProductProjection> products = productService.getAllProducts(pageable, categoryId);
        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(),
                products.getTotalElements(), ProductResponseDTO.class);
    }


    public ProductResponseDTO getProductById(Long productId) {
        return commonMapper.convertToResponse(productService.getProductById(productId), ProductResponseDTO.class);
    }

}
