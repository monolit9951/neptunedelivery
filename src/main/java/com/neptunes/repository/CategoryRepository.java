package com.neptunes.repository;

import com.neptunes.domain.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query( "SELECT c FROM Category c ORDER BY c.id ASC" )
    Page<Category> findAllByCategoryByIdAsc(Pageable pageable);

    @Query(value = "SELECT EXISTS (SELECT 1 FROM category WHERE id = :categoryId)", nativeQuery = true)
    boolean isCategoryExists(@Param("categoryId") Long categoryId);
}
