package com.example.main.services;


import com.example.main.models.Certificate;
import com.example.main.repositories.CertificateRepository;
import com.example.main.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    @Override
    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    @Override
    public Certificate addCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    @Override
    public Certificate updateCertificate(Long id, Certificate certificate) {
        return certificateRepository.findById(id).map(existingCertificate -> {
            existingCertificate.setName(certificate.getName());
            existingCertificate.setProvider(certificate.getProvider());
            existingCertificate.setValidUntil(certificate.getValidUntil());
            existingCertificate.setDescription(certificate.getDescription());
            existingCertificate.setRealPrice(certificate.getRealPrice());
            return certificateRepository.save(existingCertificate);
        }).orElseThrow(() -> new RuntimeException("Certificate not found with id " + id));
    }

    @Override
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
