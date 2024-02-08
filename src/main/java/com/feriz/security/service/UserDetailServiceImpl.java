package com.feriz.security.service;

import com.feriz.domain.Account;
import com.feriz.domain.Role;
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.repository.AccountRepository;
import com.feriz.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private  final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account=accountRepository.findByUserName(username).orElseThrow(()->
                new ResourceNotFoundException("bu kullanıcı bulunamadı : "+username));

        if (account!=null){
            return new User(account.getUserName(),
                            account.getPassword(),
                            buildGrantedAuthorities(account.getRoles()));
        }else {
            throw new UsernameNotFoundException("Acoount bulanamadı."+username);
        }




    }


    private static List<SimpleGrantedAuthority> buildGrantedAuthorities(final Set<Role> roles){
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();

        roles.forEach(t-> authorities.add(new SimpleGrantedAuthority(t.getName().name())));
        return authorities;
    }



}
