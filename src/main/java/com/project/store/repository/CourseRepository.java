package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findAll();
	
	Optional<Course> findById(Long courseId);
	
	List<Course> findByDomain(String domain);
}
