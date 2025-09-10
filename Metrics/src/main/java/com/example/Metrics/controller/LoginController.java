package com.example.Metrics.controller;


import com.example.Metrics.config.LoginMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginMetrics loginMetrics;

    @Autowired
    public LoginController(LoginMetrics loginMetrics) {
        this.loginMetrics = loginMetrics;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        loginMetrics.incrementLoginAttempt();

        // logic
        if ("user".equals(username) && "pass".equals(password)) {
            loginMetrics.incrementLoginSuccess();
            return ResponseEntity.ok("Login Successful!");
        } else {
            loginMetrics.incrementLoginFailure();
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

