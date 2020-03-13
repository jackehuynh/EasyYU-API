package com.easyyu.security;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

// Grabs header value for authentication with custom API key
public class APIAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    public String header;
    public String result;

    public APIAuthFilter(String header) {
        this.header = header;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(header);
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getUserPrincipal();
    }
}
