package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.store.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/*
	 * The functions I used to reach the information I would use are
	 * 
	 * findAll
	 * findById
	 * findByLoginContains (I used this one to do a partial search '%#%' for user records with the login/username we type)
	 */
	
	List<User> findAll();
	
	Optional<User> findById(Long userId);

	List<User> findByLoginContains(String login);
}
