package com.feriz.service;

import com.feriz.domain.Role;
import com.feriz.domain.enums.AccountRole;
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByType(AccountRole accountRole) {
        return roleRepository.findByName(accountRole).orElseThrow(()->
                new ResourceNotFoundException("Role bulunamadı:"+accountRole.name()));

    }
}
