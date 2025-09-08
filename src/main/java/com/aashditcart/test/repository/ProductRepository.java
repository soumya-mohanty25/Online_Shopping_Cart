package com.aashditcart.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.CartItem;
import com.aashditcart.test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String name);
	void save(List<CartItem> cartItems);

}
