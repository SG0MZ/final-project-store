package com.project.store.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.model.User;
import com.project.store.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public User addUser(@RequestBody User newUser) {
		return userService.saveUser(newUser);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody User newUser) {
		if(userService.getUserById(newUser.getId()) == null)
			return new ResponseEntity<>("User id cant be null",
                    HttpStatus.NOT_FOUND);
		
		userService.saveUser(newUser);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUserById(id);
	}
	
}
