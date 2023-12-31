package com.project.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.store.model.User;
import com.project.store.repository.UserRepository;
import com.project.store.security.CustomSecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
//		User user = userRepo.findByUsername(userName);
//		
//		if(user == null)
//			throw new UsernameNotFoundException("Username and/or password was incorrect.");
//		
//		return new CustomSecurityUser(user);
//	}
	
}
