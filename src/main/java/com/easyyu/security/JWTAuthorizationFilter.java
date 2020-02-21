package com.easyyu.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.easyyu.users.CustomUserDetails;
import com.easyyu.users.User;
import com.easyyu.users.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {

        // Grab token from request header
        String token = request.getHeader(JWTConstants.HEADER_STRING);

        // if token isn't null decode it and try to validate it
        if (token != null) {
            // parse (decode) the token and validate/verify it
            String username = JWT.require(Algorithm.HMAC512(JWTConstants.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(JWTConstants.TOKEN_PREFIX, ""))
                    .getSubject(); // Subject is the username since we set the subject as username from JWT authentication filter


            // Search in database to find the user by the token subject (aka username)
            // If found, grab user details and create spring auth token using username, password, and authorities/roles
            if (username != null) {
                User user = userService.findByUsername(username);
                CustomUserDetails customUserDetails = new CustomUserDetails(user);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, customUserDetails.getAuthorities()
                );
                return auth;
            }
            return null;
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        // Read the Authorization header, where the JWT token is located
        String header = request.getHeader(JWTConstants.HEADER_STRING);

        // If header does not contain BEARER or is null delegate to Spring implementation and exit
        if (header == null || !header.startsWith(JWTConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // if Header is present, try and grab user details from database and perform authorization
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue filter execution
        chain.doFilter(request, response);
    }
}
