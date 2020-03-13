package com.easyyu.security;

import com.easyyu.users.User;
import com.easyyu.users.UserService;
import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.UUID;

@Component
public class TokenProvider {

    @Autowired
    private UserService userService;

    private static String token;
    private static final SecureRandom secureRandom = new SecureRandom();

    // Generate token for the given user
    public String generateToken(String username) {
        // need to change to load user by email
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }

        UUID uuid = Generators.randomBasedGenerator().generate();
        token = uuid.toString().replace("-", "");

        System.out.println(token);
        return token;
    }

    // Checks if user has a generated token
    public Boolean validateToken(String username) {
        User user = userService.findByUsername(username);
        return user.getToken() != null;
    }

}
