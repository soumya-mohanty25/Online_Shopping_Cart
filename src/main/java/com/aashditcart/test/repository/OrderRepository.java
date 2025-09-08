package com.aashditcart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.Order;
import com.aashditcart.test.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUser(User user);

}
