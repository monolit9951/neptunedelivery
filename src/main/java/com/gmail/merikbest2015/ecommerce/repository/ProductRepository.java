package com.gmail.merikbest2015.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gmail.merikbest2015.ecommerce.domain.Product;
import com.gmail.merikbest2015.ecommerce.repository.projection.ProductProjection;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query( "SELECT product FROM Product product ORDER BY product.id ASC" )
    Page<ProductProjection> findAllByOrderByIdAsc( Pageable pageable );
}
