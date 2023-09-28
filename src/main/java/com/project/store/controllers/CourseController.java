package com.project.store.controllers;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.project.store.model.Course;
import com.project.store.model.wrappers.CoursesWrapper;
import com.project.store.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("courses")
public class CourseController {

	/*
	 * With this controller we use the course services
	 * 
	 * getAllCourses
	 * getCourseById
	 * getCourseByDomain (This will return the Course Wrapper which will allow an empty list)
	 * getCourseByCourseName
	 * addCourse
	 * modifyCourse (This returns a ResponseEntity in case the controller works or not)
	 * deleteCourseById (Included a try catch for EmptyResultDataAccessException, NumberFormatException and MethodArgumentTypeMismatchException)
	 * 
	 * In the Swagger UI you can test the requests. It will include a description, and examples on how to send the add and modify requests.
	 */
	
	private final CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}
	
//	@ModelAttribute("courseList")
	@Operation(summary = "Get All Courses", description = "Returns a list of all courses.")
	@GetMapping
	public List<Course> getAllCourses() {
		return courseService.getAllCourses();
	}
//	public String getAllCourses(Model model) {
//		model.addAttribute("courseList", courseService.getAllCourses());
//	    return "courses";
//	}
	
	@Operation(summary = "Get Course By Id", description = "Returns a course by its id.")
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}
	
	@Operation(summary = "Get Course By Domain", description = "Returns a list of all courses with the same domain.")
	@GetMapping("/domain")
	public CoursesWrapper getCourseByDomain(@RequestParam(name = "domain", required = false) String domain) {
		if (domain != null && !domain.isEmpty()) {
            return new CoursesWrapper(courseService.getCourseByDomain(domain));
        }
        return new CoursesWrapper(courseService.getAllCourses());
	}
	
	@Operation(summary = "Get Course By Name", description = "Returns a course by its name (partial search '%#%').")
	@GetMapping("/courseName")
	public List<Course> getCourseByCourseName(@RequestParam(name = "courseName", required = false) String courseName) {
		return courseService.getCourseByCourseName(courseName);
	}
	
	@Operation(summary = "Add New Course", description = "Creates a new course.")
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
//	public String addCourse(@RequestBody Course course, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//            return "add-user";
//        }
//		return "courses";
//	}
	
	@Operation(summary = "Modify Course", description = "Updates a course.")
	@PutMapping
	public ResponseEntity<String> modifyCourse(@RequestBody Course newCourse) {
		if(courseService.getCourseById(newCourse.getId()) == null)
			return new ResponseEntity<>("Course id cant be null",
                    HttpStatus.NOT_FOUND); 
		courseService.saveCourse(newCourse);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@Operation(summary = "Delete Course By Id", description = "Deletes a course by its id.")
	@DeleteMapping("/{id}")
	public void deleteCourseById(@PathVariable Long id) {
		try {
			courseService.deleteCourse(id);
		} catch(EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		} catch(MethodArgumentTypeMismatchException | NumberFormatException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
}
