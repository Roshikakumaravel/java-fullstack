package com.edu.personalfinance.controllers;

import com.edu.personalfinance.models.User;
import com.edu.personalfinance.services.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        // If validation fails, it won't reach this point (handled by Spring Boot automatically)
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // User login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }
}