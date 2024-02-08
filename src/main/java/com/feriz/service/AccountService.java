package com.feriz.service;

import com.feriz.domain.Account;
import com.feriz.domain.Role;
import com.feriz.domain.enums.AccountRole;
import com.feriz.dto.AccountRequest;
import com.feriz.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    public void saveAccount(AccountRequest request) {
        Account account=new Account();
        account.setName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setUserName(request.getUserName());

        String password=request.getPassword();
        String encodedPasword=passwordEncoder.encode(password);
        account.setPassword(encodedPasword);

        Role role=roleService.getRoleByType(AccountRole.ROLE_ADMIN);
        Set<Role> roles=new HashSet<>();
        roles.add(role);

        account.setRoles(roles);
        accountRepository.save(account);

    }
}
