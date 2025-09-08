package com.aashditcart.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashditcart.test.model.User;
import com.aashditcart.test.repository.UserRepository;
import com.aashditcart.test.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		 userRepository.save(user);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public void updateUser(User user) {

		userRepository.save(user);
	}

	@Override
	public User findById(Long id) {		
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
}
