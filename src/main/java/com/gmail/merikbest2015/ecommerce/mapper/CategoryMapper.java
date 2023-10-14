package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.dto.HeaderResponse;
import com.gmail.merikbest2015.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.gmail.merikbest2015.ecommerce.dto.category.response.*;
import com.gmail.merikbest2015.ecommerce.repository.projection.*;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    private final CommonMapper commonMapper;
    private final CategoryService categoryService;

    public HeaderResponse<CategoryResponse> getAllCategories(Pageable pageable) {
        Page<CategoryProjection> category = categoryService.getAllCategories(pageable);
        return commonMapper.getHeaderResponse(category.getContent(), category.getTotalPages(),
                category.getTotalElements(), CategoryResponse.class);
    }

}
