package com.feriz.repository;

import com.feriz.domain.Role;
import com.feriz.domain.enums.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(AccountRole accountRole);
}
