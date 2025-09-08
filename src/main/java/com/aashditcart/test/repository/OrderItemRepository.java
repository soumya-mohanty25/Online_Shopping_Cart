package com.aashditcart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
