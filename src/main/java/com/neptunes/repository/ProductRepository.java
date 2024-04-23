package com.neptunes.repository;

import com.neptunes.domain.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT product FROM Product product ORDER BY product.id ASC")
    Page<Product> findAllByOrderByIdAsc(Pageable pageable);

    @Query("SELECT product FROM Product product WHERE product.categoryId = :categoryId ORDER BY product.id ASC")
    Page<Product> findAllByCategoryIdOrderByIdAsc(Pageable pageable, Long categoryId);


}
