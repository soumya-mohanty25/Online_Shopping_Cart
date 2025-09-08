package com.aashditcart.test.service;

import com.aashditcart.test.model.User;

public interface UserService {

	void saveUser(User user);

	User findByUsernameAndPassword(String username, String password);

	void updateUser(User user);

	User findById(Long id);
	
	User getUserById(Long userId);

	

}
