package com.example.main.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/demo")
public class Demo {

    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public String hello() {
        return "Hello from Spring boot & Keycloak";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2() {
        return "Hello from Spring boot & Keycloak - ADMIN";
    }

    @GetMapping("/userinfo")
    @PreAuthorize("hasRole('manage-account')")
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return "Authenticated user: " + username;
        } else {
            return "User not authenticated";
        }
    }
}