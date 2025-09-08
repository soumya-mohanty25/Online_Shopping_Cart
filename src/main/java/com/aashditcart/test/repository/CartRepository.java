package com.aashditcart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.Cart;
import com.aashditcart.test.model.User;

public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUserId(Long userId);

	Cart findByUser(User user);

}
