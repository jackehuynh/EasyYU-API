package com.easyyu.security;

import com.easyyu.users.CustomUserDetailsService;
import com.easyyu.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class RestApiSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Value("${api_header}")
        private String header;

        // return authentication filter with header and token values
        public APIAuthFilter authFilter() {
            APIAuthFilter filter = new APIAuthFilter(header);
            filter.setAuthenticationManager(new AuthenticationManager() {

                @Override
                public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                    String principal = (String) authentication.getPrincipal();

                    // TODO: find another way to check if token is valid. Use authentication provider?
                    String token = userService.getToken(principal);
                    System.out.println("Token in webconfig: " + token);

                    if (!token.equals(principal)) {
                        System.out.println("Auth failed. Token does not much.");
                        throw new SecurityException("Auth failed.");
                    } else {
                        System.out.println("Authentication successful. " + token);
                        authentication.setAuthenticated(true);
                        return authentication;
                    }
                }
            });
            return filter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")
                    .csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilter(authFilter())
                    .authorizeRequests()
                    .anyRequest().authenticated();
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }

    @Configuration
    @Order(2)
    public static class FormLoginWebSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private AuthenticateSuccessHandler authSuccessHandler;

        @Autowired
        private PasswordEncoder bCryptPasswordEncoder;

        @Autowired
        private CustomUserDetailsService userDetailsServices;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .cors()
                    .and()
                    .csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/signup", "/login", "/docs", "/", "/resources/**").permitAll()
                        .antMatchers("/dashboard").authenticated()
                        .antMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .successHandler(authSuccessHandler)
                        .permitAll()
                    .and()
                        .logout()
                        .logoutSuccessUrl("/login").permitAll()
                        .deleteCookies("JSESSIONID")
                    .and()
                        .exceptionHandling();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .userDetailsService(this.userDetailsServices)
                    .passwordEncoder(this.bCryptPasswordEncoder);
            auth.eraseCredentials(false);
        }

        // this method allows static resources to be ignored by spring security
        @Override
        public void configure(WebSecurity web) throws Exception {
            web
                    .ignoring()
                    .antMatchers("/font-awesome/**", "/bootstrap/**")
                    .antMatchers("/actuator/**");
        }
    }
}
