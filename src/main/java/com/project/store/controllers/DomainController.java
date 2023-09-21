package com.project.store.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.store.model.Domain;
import com.project.store.service.DomainService;

@RestController
public class DomainController {
	
	private final DomainService domainService;
	
	public DomainController(DomainService domainService) {
		this.domainService = domainService;
	}
	
	@GetMapping("/domains")
	public List<Domain> getAllDomains() {
		return domainService.getAllDomains();
	}
	
	@GetMapping("/domains/{id}")
	public Domain getDomainById(@PathVariable Long id) {
		return domainService.getDomainById(id);
	}
}
