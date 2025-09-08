package com.aashditcart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aashditcart.test.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

	User getUserById(Long userId);
}
