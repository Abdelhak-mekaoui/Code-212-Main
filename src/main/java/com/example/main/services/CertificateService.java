package com.example.main.services;


import com.example.main.models.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateService {

    List<Certificate> getAllCertificates();
    Optional<Certificate> getCertificateById(Long id);
    Certificate addCertificate(Certificate certificate);
    Certificate updateCertificate(Long id, Certificate certificate);
    void deleteCertificate(Long id);
}
