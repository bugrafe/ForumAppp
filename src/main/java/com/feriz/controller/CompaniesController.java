package com.feriz.controller;

import com.feriz.domain.Companies;
<<<<<<< HEAD
import com.feriz.dto.CompaniesDTO;
import com.feriz.mapper.CompaniesMapper;
import com.feriz.messages.Message;
=======
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
import com.feriz.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Controller;
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
=======

@RestController
@RequestMapping("companies")
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;
<<<<<<< HEAD
    @Autowired
    private CompaniesMapper companiesMapper;



    @PostMapping
    public ResponseEntity<Map<String,String>> save(@Valid @RequestBody CompaniesDTO companies){
=======


    @PostMapping
    public ResponseEntity<Map<String,String>> save(@Valid @RequestBody Companies companies){
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
        companiesService.saveCompanies(companies);
        Map<String,String> response=new HashMap<>();
        response.put("message","Companies save successfully.");
        response.put("Status","active");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
<<<<<<< HEAD
=======

>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
<<<<<<< HEAD
    public ResponseEntity<List<CompaniesDTO>> getAllList(){
        List<Companies> companiesList=companiesService.getAllListCompanies();
        List<CompaniesDTO> companiesDTOS=companiesList.stream().map(companiesMapper::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(companiesDTOS);
    }

    @DeleteMapping("/deleteAccount")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteAccount(@RequestParam Long id) {
        companiesService.deleteAccount(id);
        return ResponseEntity.ok(Message.DELETE_SUCCESFULLY);
    }

    @GetMapping("/findByEmail")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CompaniesDTO> findByEmail(@RequestParam String email){
        return companiesService.findByEmail(email);
    }


=======
    public ResponseEntity<List<Companies>> getAllList(){
        List<Companies> companiesList=companiesService.getAllListCompanies();
        return ResponseEntity.ok(companiesList);
    }

>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee


}
