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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.model.Course;
import com.project.store.model.wrappers.CoursesWrapper;
import com.project.store.service.CourseService;

@RestController
@RequestMapping("courses")
public class CourseController {

	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	@GetMapping("/domain")
	public CoursesWrapper getCourseByDomain(@RequestParam(name = "domain", required = false) String domain) {
		if (domain != null && !domain.isEmpty()) {
            return new CoursesWrapper(courseService.getCourseByDomain(domain));
        }
        return new CoursesWrapper(courseService.getAllCourses());
	}
	
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyCourse(@RequestBody Course newCourse) {
		if(courseService.getCourseById(newCourse.getId()) == null)
			return new ResponseEntity<>("Course id cant be null",
                    HttpStatus.NOT_FOUND); 
		courseService.saveCourse(newCourse);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourseById(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
	
}
