package com.project.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "users")
public class User {
	
	/*
	 * The following entity is for users
	 * 
	 * Id
	 * Login (Refers to username)
	 * Domain Expertise
	 * About (Refers to a brief description of the user)
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(name = "User Id", example = "1")
    private Long id;
	
	@Column(nullable = false, unique = true)
	@Schema(name = "User Login", example = "user1", required = true)
	private String login;
	
	@Column(nullable = false)
	@Schema(name = "User Domain Expertise", example = "Music", required = true)
	private String domainExpertise;
	
	@Schema(name = "User About", example = "A quick learner")
	private String about;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDomainExpertise() {
		return domainExpertise;
	}

	public void setDomainExpertise(String domainExpertise) {
		this.domainExpertise = domainExpertise;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public User() {
		
	}
	
	public User(Long id, String login, String domainExpertise, String about) {
		super();
		this.id = id;
		this.login = login;
		this.domainExpertise = domainExpertise;
		this.about = about;
	}
	
}
