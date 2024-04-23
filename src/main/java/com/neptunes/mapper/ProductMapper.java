package com.neptunes.mapper;

import com.neptunes.domain.Product;
import com.neptunes.dto.HeaderResponse;
import com.neptunes.dto.products.response.ProductResponseDTO;
import com.neptunes.service.ProductService;

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
        Page<Product> products = productService.getAllProducts(pageable, categoryId);
        return commonMapper.getHeaderResponse(products.getContent(), products.getTotalPages(),
                products.getTotalElements(), ProductResponseDTO.class);

//        response.getItems().forEach(item-> item.);
//        List<ProductResponseDTO> response = products.getContent().stream().map(x->ProductResponseDTO.builder().build());
//        return response;
    }


    public ProductResponseDTO getProductById(Long productId) {
        return commonMapper.convertToResponse(productService.getProductById(productId), ProductResponseDTO.class);
    }

}
