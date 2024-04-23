package com.neptunes.service.Impl;

import com.neptunes.domain.Category;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.repository.CategoryRepository;
import com.neptunes.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.neptunes.constants.ErrorMessage.CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAllByCategoryByIdAsc(pageable);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiRequestException(CATEGORY_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @Override
    public boolean isCategoryExists(Long categoryId) {
        return categoryRepository.isCategoryExists(categoryId);
    }
}
