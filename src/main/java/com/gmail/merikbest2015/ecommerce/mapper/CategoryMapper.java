package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.domain.Category;
import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.dto.category.response.CategoryResponseDTO;
import com.gmail.merikbest2015.ecommerce.repository.projection.CategoryProjection;
import com.gmail.merikbest2015.ecommerce.service.CategoryService;
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
        Page<CategoryProjection> category = categoryService.getAllCategories(pageable);
        return commonMapper.getHeaderResponse(category.getContent(), category.getTotalPages(),
                category.getTotalElements(), CategoryResponseDTO.class);
    }

    public CategoryResponseDTO getCategoryById(Long categoryId) {
        return commonMapper.convertToResponse(categoryService.getCategoryById(categoryId), CategoryResponseDTO.class);
    }

    public CategoryResponseDTO updateCategoryImg(Long categoryId, String img) {
        Category category = categoryService.updateCategoryImg(categoryId, img);
        return commonMapper.convertToResponse(category, CategoryResponseDTO.class);
    }
}
