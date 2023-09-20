package com.project.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.store.model.Domain;
import com.project.store.repository.DomainRepository;

@Service
public class DomainService {

	private DomainRepository domainRepository;
	
	public List<Domain> getAllCourses() {
		return domainRepository.findAll();
	}
	
	public Domain getCourseById(Long id) {
		return domainRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(String.format("Domain with id %s doesn't exist", id)));
	}
}
