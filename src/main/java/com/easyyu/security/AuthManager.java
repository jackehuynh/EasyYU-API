package com.easyyu.security;

import com.easyyu.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

public class AuthManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Value("${api_header}")
    private String header;

    @Override
    public Authentication authenticate(Authentication authentication) {
       String principal = (String) authentication.getPrincipal();
       String token = userService.getToken(principal);
       System.out.println("Principal: " + principal);
       System.out.println("Token: " + token);

       // Checks if user token matches passed token in header
       if (!token.equals(principal)) {
           System.out.println("Token mismatch.");
           throw new BadCredentialsException("Wrong API key/header");
       } else {
           authentication.setAuthenticated(true);
           System.out.println("Authentication successful");
           return authentication;
       }
    }
}
