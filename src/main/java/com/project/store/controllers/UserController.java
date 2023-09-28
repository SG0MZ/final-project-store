package com.project.store.controllers;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.ResponseStatusException;

import com.project.store.model.User;
import com.project.store.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("users")
public class UserController {

	/*
	 * With this controller we use the user services
	 * 
	 * getAllUsers
	 * getUserById
	 * getUserByUsername
	 * addUser (Included a try catch for any Exception)
	 * modifyUser (This returns a ResponseEntity in case the controller works or not)
	 * deleteUserById (Included a try catch for EmptyResultDataAccessException, NumberFormatException and MethodArgumentTypeMismatchException)
	 * 
	 * In the Swagger UI you can test the requests. It will include a description, and examples on how to send the add and modify requests.
	 */
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Operation(summary = "Get All Users", description = "Returns a list of all users.")
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@Operation(summary = "Get User By Id", description = "Returns a user by its id.")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@Operation(summary = "Get User By Username", description = "Returns a user by its username (partial search '%#%').")
	@GetMapping("/userName")
	public List<User> getUserByUsername(@RequestParam(name = "userName", required = false)  String login) {
		return userService.getUserByUsername(login);
	}
	
	@Operation(summary = "Add New User", description = "Creates a new user.")
	@PostMapping
	public User addUser(@RequestBody User newUser) throws Exception {
		try {
			return userService.saveUser(newUser);
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Operation(summary = "Modify User", description = "Updates a user.")
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody User newUser) {
		if(userService.getUserById(newUser.getId()) == null)
			return new ResponseEntity<>("User id cant be null",
                    HttpStatus.NOT_FOUND);
		
		userService.saveUser(newUser);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@Operation(summary = "Delete User By Id", description = "Deletes a user by its id.")
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		try {
			userService.deleteUserById(id);
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		} catch(MethodArgumentTypeMismatchException | NumberFormatException e1) {
			System.out.println(e1.getMessage());
		}
		
	}
	
}
