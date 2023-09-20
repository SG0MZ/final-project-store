package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.model.Domain;

public interface DomainRepository extends JpaRepository<Domain, Long> {
	
	List<Domain> findAll();
	
	Optional<Domain> findById(Long courseId);
	
}