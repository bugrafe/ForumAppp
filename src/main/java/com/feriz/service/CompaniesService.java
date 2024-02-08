package com.feriz.service;

import com.feriz.domain.Companies;
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.repository.CompaniesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompaniesService {

    private final CompaniesRepository companiesRepository;


    public List<Companies> getAllListCompanies() {
        return companiesRepository.findAll();
    }

    public void saveCompanies(Companies companies) {

        if (companiesRepository.existsByEmail(companies.getEmail())){
            throw new ResourceNotFoundException("email daha önce kullanılmış");
        }

        if (companiesRepository.existsByPhone(companies.getPhone())){
            throw new ResourceNotFoundException("phone daha önce kullanılmış");
        }

        companiesRepository.save(companies);
    }
}
