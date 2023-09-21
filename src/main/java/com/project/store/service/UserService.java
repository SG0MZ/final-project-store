package com.project.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.store.model.User;
import com.project.store.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(String.format("Product with id %s doesn't exist", id)));
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
	
}
