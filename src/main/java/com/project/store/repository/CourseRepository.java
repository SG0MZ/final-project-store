package com.project.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.store.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	/*
	 * The functions I used to reach the information I would use are
	 * 
	 * findAll
	 * findById
	 * findByDomain
	 * findByCourseNameContains (I used this one to do a partial search '%#%' for course records with name we type)
	 */
	
	List<Course> findAll();
	
	Optional<Course> findById(Long courseId);
	
	List<Course> findByDomain(String domain);
	
	List<Course> findByCourseNameContains(String courseName);
}
