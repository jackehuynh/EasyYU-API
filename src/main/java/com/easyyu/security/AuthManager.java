package com.easyyu.security;

import com.easyyu.users.User;
import com.easyyu.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;

public class AuthManager implements AuthenticationManager {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String header = AuthConstants.header;
//       User user = userService.findByUsername(authentication.getName());

//       String token = userService.getToken(authentication.getName());
       String principal = (String) authentication.getPrincipal();
//       String token = "71af29ae416c4466af29ae416c446609";
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
