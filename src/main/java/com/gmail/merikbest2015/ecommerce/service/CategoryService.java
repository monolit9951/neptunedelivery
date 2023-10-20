package com.gmail.merikbest2015.ecommerce.service;

import com.gmail.merikbest2015.ecommerce.domain.Category;
import com.gmail.merikbest2015.ecommerce.repository.projection.CategoryProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<CategoryProjection> getAllCategories(Pageable pageable);

    Category getCategoryById(Long categoryId );
    boolean isCategoryExists(Long categoryId);



}
