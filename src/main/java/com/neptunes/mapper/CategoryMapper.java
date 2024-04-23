package com.neptunes.mapper;

import com.neptunes.domain.Category;
import com.neptunes.dto.HeaderResponse;
import com.neptunes.dto.category.response.CategoryResponseDTO;
import com.neptunes.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final CommonMapper commonMapper;
    private final CategoryService categoryService;

    public HeaderResponse<CategoryResponseDTO> getAllCategories(Pageable pageable) {
        Page<Category> category = categoryService.getAllCategories(pageable);
        return commonMapper.getHeaderResponse(category.getContent(), category.getTotalPages(),
                category.getTotalElements(), CategoryResponseDTO.class);
    }

    public CategoryResponseDTO getCategoryById(Long categoryId) {
        return commonMapper.convertToResponse(categoryService.getCategoryById(categoryId), CategoryResponseDTO.class);
    }
}
