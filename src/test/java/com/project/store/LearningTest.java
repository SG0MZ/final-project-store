package com.project.store;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LearningTest {
  
  @Test
  public void encrypt_password () {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    String encodedPassword = passwordEncoder.encode("password789");
    
    System.out.println(encodedPassword);
  }
}
