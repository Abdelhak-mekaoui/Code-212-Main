package com.example.main.controllers;


import com.example.main.models.*;
import com.example.main.services.CertificateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-certificates")
public class CertificateUserController {

    @Autowired
    private CertificateUserService certificateUserService;

    @GetMapping
    @PreAuthorize("hasRole('manage-account')")
    public List<CertificateUser> getUserCertificates() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        return certificateUserService.getCertificatesByUser(userId);
    }

    @PostMapping
    @PreAuthorize("hasRole('manage-account')")
    public CertificateUser addCertificateToUser(@RequestBody Certificate certificate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        return certificateUserService.addCertificateToUser(userId, certificate);
    }
}

