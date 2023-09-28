package com.project.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "courses")
public class Course {
	
	/*
	 * The following entity is for courses
	 * 
	 * Id
	 * Domain Name
	 */
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(name = "Course Id", example = "1")
    private Long id;
	
	@Column(nullable = false, unique = true)
	@Schema(name = "Course Name", example = "Guitar Advanced", required = true)
	private String courseName;
	
	@Column(nullable = false)
	@Schema(name = "Course Domain", example = "Music", required = true)
	private String domain;
	
	@Column(nullable = false)
	@Schema(name = "Course Description", example = "For experienced people", required = true)
	private String description;
	
	@Column(nullable = false)
	@Schema(name = "Course Price", example = "100.0", required = true)
	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Course() {
		
	}
	
	public Course(Long id, String courseName, String domain, String description, Double price) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.domain = domain;
		this.description = description;
		this.price = price;
	}
	
}
