package com.example.main.repositories;


import com.example.main.models.CertificateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateUserRepository extends JpaRepository<CertificateUser, Long> {
    List<CertificateUser> findByUserId(String userId);
}
