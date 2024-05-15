package com.gmail.merikbest2015.ecommerce.repository;

import com.gmail.merikbest2015.ecommerce.domain.Order;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.repository.projection.OrderProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
