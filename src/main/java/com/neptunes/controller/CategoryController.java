package com.neptunes.controller;

import com.neptunes.dto.HeaderResponse;
import com.neptunes.dto.category.response.CategoryResponseDTO;
import com.neptunes.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories(Pageable pageable) {
        HeaderResponse<CategoryResponseDTO> response = categoryMapper.getAllCategories(pageable);
        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryMapper.getCategoryById(categoryId));
    }
}
