package com.feriz.repository;

import com.feriz.domain.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
=======
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee

public interface CompaniesRepository extends JpaRepository<Companies,Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
<<<<<<< HEAD

    @Query("SELECT c FROM Companies c WHERE c.email=?1")
    Optional<Companies> findByEmail(String email);
=======
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
}
