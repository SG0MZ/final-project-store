package com.project.store.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
	private String login;
	
	private String password;
	
	private Set<Authorities> authorities = new HashSet<Authorities>();
	
	@Column(nullable = false)
	private String domainExpertise;
	
	private String about;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="users")
	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public User(Long id, String login, String password, String domainExpertise, String about) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.domainExpertise = domainExpertise;
		this.about = about;
	}
	
}
