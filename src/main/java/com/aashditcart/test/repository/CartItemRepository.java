package com.aashditcart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	CartItem save(CartItem cartItem);

}
