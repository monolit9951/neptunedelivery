package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.domain.Category;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.CategoryRepository;
import com.gmail.merikbest2015.ecommerce.repository.projection.CategoryProjection;
import com.gmail.merikbest2015.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<CategoryProjection> getAllCategories(Pageable pageable) {
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

    public Category updateCategoryImg(Long categoryId, String img) {
        Category updateCategory = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ApiRequestException(CATEGORY_NOT_FOUND, HttpStatus.BAD_REQUEST));

        updateCategory.setImg(img);
        return categoryRepository.save(updateCategory);
    }
}
