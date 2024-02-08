package com.feriz.controller;

import com.feriz.dto.AccountRequest;
import com.feriz.dto.LoginRequest;
import com.feriz.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;



    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody AccountRequest accountRequest){
        accountService.saveAccount(accountRequest);
        String myResponse="Account başarıyla kaydedildi.";
        return new ResponseEntity<>(myResponse, HttpStatus.CREATED);//201

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest){
        String myresponse="login başarılıç";
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                loginRequest.getPassword()));
        return new ResponseEntity<>(myresponse,HttpStatus.OK);

    }



}
