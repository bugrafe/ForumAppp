package com.feriz.controller;

import com.feriz.domain.Companies;
import com.feriz.dto.CompaniesDTO;
import com.feriz.mapper.CompaniesMapper;
import com.feriz.messages.Message;
import com.feriz.service.CompaniesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("companies")
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;
    @Autowired
    private CompaniesMapper companiesMapper;


    @PostMapping("/save")
    public ResponseEntity<Map<String,String>> save(@Valid @RequestBody CompaniesDTO companiesDTO){
        companiesService.saveCompanies(companiesDTO);
        Map<String,String> response=new HashMap<>();
        response.put("message","Companies save successfully.");
        response.put("Status","active");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
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

}
