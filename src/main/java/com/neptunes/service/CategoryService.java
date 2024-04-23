package com.neptunes.service;

import com.neptunes.domain.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<Category> getAllCategories(Pageable pageable);

    Category getCategoryById(Long categoryId );

    boolean isCategoryExists(Long categoryId);



}
