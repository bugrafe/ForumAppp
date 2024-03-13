package com.feriz.repository;

import com.feriz.domain.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompaniesRepository extends JpaRepository<Companies,Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);


    Optional<Companies> findByEmail(String email);
}
