package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	/*
	 * The functions I used to reach the information I would use are
	 * 
	 * saveAll
	 * findAll
	 * findById
	 * findByFirstNameAndLastName
	 */
	
	<S extends Order> List<S> saveAll(Iterable<S> orders);
	
	List<Order> findAll();
	
	Optional<Order> findById(Long orderId);
	
	List<Order> findByFirstNameAndLastName(String firstName, String lastName);
}
