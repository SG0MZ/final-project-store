package com.project.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.store.model.Domain;
import com.project.store.repository.DomainRepository;

@Service
public class DomainService {

	private final DomainRepository domainRepository;
	
	public DomainService(DomainRepository domainRepository) {
		this.domainRepository = domainRepository;
	}
	
	public List<Domain> getAllDomains() {
		return domainRepository.findAll();
	}
	
	public Domain getDomainById(Long id) {
		return domainRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(String.format("Domain with id %s doesn't exist", id)));
	}
}
