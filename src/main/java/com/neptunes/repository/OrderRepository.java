package com.neptunes.repository;

import com.neptunes.domain.Order;
import com.neptunes.repository.projection.OrderProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o ORDER BY o.id ASC")
    Page<OrderProjection> findAllByOrderByIdAsc(Pageable pageable);

    @Query(value = "SELECT EXISTS (SELECT 1 FROM orders WHERE id = :orderId)", nativeQuery = true)
    boolean isOrderExists(@Param("orderId") Long orderId);
//
//    Page<Order> findAllByOrderByIdAsc(Pageable pageable);
//
//    List<Order> findOrderByEmail(String email);
//
//    Page<Order> findOrderByEmail(String email, Pageable pageable);
}
