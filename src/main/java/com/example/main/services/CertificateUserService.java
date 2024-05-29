package com.example.main.services;

import com.example.main.models.Certificate;
import com.example.main.models.CertificateUser;

import java.util.List;

public interface CertificateUserService {

    List<CertificateUser> getCertificatesByUser(String userId);
    CertificateUser addCertificateToUser(String userId, Certificate certificate);
}
