package com.project.store.model.wrappers;

import com.project.store.model.Course;

import java.util.Collections;
import java.util.List;

public class CoursesWrapper {

	private List<Course> courses = Collections.emptyList();
	 
    public CoursesWrapper(List<Course> courses) {
        this.courses = Collections.unmodifiableList(courses);
    }
 
    public List<Course> getCourses() {
        return courses;
    }
}
