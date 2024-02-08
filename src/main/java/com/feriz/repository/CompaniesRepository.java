package com.feriz.repository;

import com.feriz.domain.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies,Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}
