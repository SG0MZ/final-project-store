package com.project.store.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.store.model.User;

public class CustomSecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -5390904701002825178L;

	public CustomSecurityUser() {
		
	}
	
//	public CustomSecurityUser(User user) {
//		this.setAuthorities(user.getAuthorities());
//		this.setId(user.getId());
//		this.setPassword(user.getPassword());
//		this.setLogin(user.getLogin());
//	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
