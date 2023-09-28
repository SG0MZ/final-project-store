package com.project.store.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.model.Domain;
import com.project.store.service.DomainService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DomainController {
	
	/*
	 * With this controller we use the domain services
	 * 
	 * getAllDomains
	 * getDomainById
	 * 
	 * In the Swagger UI you can test the requests.
	 */
	
	private final DomainService domainService;
	
	public DomainController(DomainService domainService) {
		this.domainService = domainService;
	}
	
	@Operation(summary = "Get All Domains", description = "Returns a list of all domains.")
	@GetMapping("/domains")
	public List<Domain> getAllDomains() {
		return domainService.getAllDomains();
	}
	
	@Operation(summary = "Get Domain By Id", description = "Returns a domain by its id.")
	@GetMapping("/domains/{id}")
	public Domain getDomainById(@PathVariable Long id) {
		return domainService.getDomainById(id);
	}
}
