package com.feriz.controller;

import com.feriz.domain.Companies;
import com.feriz.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("companies")
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;


    @PostMapping
    public ResponseEntity<Map<String,String>> save(@Valid @RequestBody Companies companies){
        companiesService.saveCompanies(companies);
        Map<String,String> response=new HashMap<>();
        response.put("message","Companies save successfully.");
        response.put("Status","active");
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Companies>> getAllList(){
        List<Companies> companiesList=companiesService.getAllListCompanies();
        return ResponseEntity.ok(companiesList);
    }



}
