package com.project.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.store.model.Course;
import com.project.store.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	public Course getCourseById(Long id) {
		return courseRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(String.format("Course with id %s doesn't exist", id)));
	}
	
	public List<Course> getCourseByDomain(String domain) {
		return courseRepository.findByDomain(domain);
	}
}
