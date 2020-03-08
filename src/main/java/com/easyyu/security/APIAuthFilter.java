package com.easyyu.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Grabs header for authentication with custom API key
public class APIAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    /*
    public APIAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }
    */

    public String header;
    public String result;

    public APIAuthFilter(String header) {
        this.header = header;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        result = request.getHeader(header);
        return request.getHeader(header);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getUserPrincipal();
    }

    /*
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String customHeader = AuthConstants.header;
        String header = req.getHeader(customHeader);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.print("Auth: " + authentication.getName());
        String principal = (String) authentication.getPrincipal();
        String token = "71af29ae416c4466af29ae416c446609";
        System.out.println("Principal: " + principal);
        System.out.println("Token: " + token);

        // Checks if user token matches passed token in header
        if (!token.equals(principal)) {
            System.out.println("Token mismatch.");
            throw new BadCredentialsException("Wrong API key/header");
        } else {
            authentication.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Authentication successful");
        }
    }
    private Authentication getToken(HttpServletRequest req) {
        String token = req.getHeader(AuthConstants.header);
        String test = "71af29ae416c4466af29ae416c446609";

        if (token.equals(test)) {
            Authentication auth = new
        }
    }
     */
}
