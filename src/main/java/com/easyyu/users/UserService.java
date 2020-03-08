package com.easyyu.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new UsernameNotFoundException("User exists");
        } else {
            user.setActive(true);
            user.setRoles("USER");
            user.setCreatedAt(new Date(System.currentTimeMillis()));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findByUsername(String username) {
        User user = checkIfUserExists(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void setToken(String token, String username) {
        int updatedTokenRowId = userRepository.setTokenForUsers(token, username);
        System.out.println("Successfully updated token: " + updatedTokenRowId);
    }

    public String getToken(String token) {
        return userRepository.getToken(token);
    }

    private User checkIfUserExists(String username) {
        return userRepository.findByUsername(username);
    }
}
