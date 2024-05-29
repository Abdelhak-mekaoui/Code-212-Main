package com.example.main.services;

import com.example.main.models.Certificate;
import com.example.main.models.CertificateUser;
import com.example.main.repositories.CertificateRepository;
import com.example.main.repositories.CertificateUserRepository;
import com.example.main.services.CertificateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateUserServiceImpl implements CertificateUserService {

    @Autowired
    private CertificateUserRepository certificateUserRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Override
    public List<CertificateUser> getCertificatesByUser(String userId) {
        return certificateUserRepository.findByUserId(userId);
    }

    @Override
    public CertificateUser addCertificateToUser(String userId, Certificate certificate) {
        Certificate savedCertificate = certificateRepository.save(certificate);
        CertificateUser certificateUser = new CertificateUser();
        certificateUser.setUserId(userId);
        certificateUser.setCertificate(savedCertificate);
        return certificateUserRepository.save(certificateUser);
    }
}
