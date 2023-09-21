package com.project.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.store.model.Course;
import com.project.store.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
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
	
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	
}
