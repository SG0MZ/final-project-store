package com.project.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//	      	.userDetailsService(userDetailsService)
//	    	.passwordEncoder(passwordEncoder);
//	    
////	    .inMemoryAuthentication()
////	    .withUser("trevor@craftycodr.com")
////	    .password("password123")
////	    .roles("USER", "ADMIN");
//	  }
//	  
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http
////	    .csrf().disable()
//	      .authorizeRequests()
//	        .antMatchers("/admin/**").hasAnyRole("ADMIN")
//	        .anyRequest().hasAnyRole("USER").and()
//	      .formLogin()
//	        .loginPage("/login")
//	        .defaultSuccessUrl("/dashboard")
//	        .permitAll();
//	      
//	  }
}
