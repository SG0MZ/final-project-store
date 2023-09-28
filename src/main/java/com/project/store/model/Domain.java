package com.project.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "domains")
public class Domain {

	/*
	 * The following entity is for domains
	 * 
	 * Id
	 * Domain Name
	 */
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Schema(name = "Domain Id", example = "1")
    private Long id;
	
	@Column(nullable = false, unique = true)
	@Schema(name = "Domain Name", example = "Music", required = true)
	private String domain;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
