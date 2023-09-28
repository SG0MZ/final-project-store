package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long> {
	
	/*
	 * The functions I used to reach the information I would use are
	 * 
	 * findAll
	 * findById
	 */
	
	List<Domain> findAll();
	
	Optional<Domain> findById(Long courseId);
	
}