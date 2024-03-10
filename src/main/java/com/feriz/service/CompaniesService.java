package com.feriz.service;

import com.feriz.domain.Companies;
<<<<<<< HEAD
import com.feriz.dto.CompaniesDTO;
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.mapper.CompaniesMapper;
import com.feriz.messages.Message;
import com.feriz.repository.AccountRepository;
import com.feriz.repository.CompaniesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
=======
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.repository.CompaniesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee

@Service
@RequiredArgsConstructor
public class CompaniesService {

    private final CompaniesRepository companiesRepository;
<<<<<<< HEAD
    private final AccountRepository accountRepository;
    private final CompaniesMapper companies;
    private final CompaniesMapper companiesMapper;

=======
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee


    public List<Companies> getAllListCompanies() {
        return companiesRepository.findAll();
    }

<<<<<<< HEAD
    public void saveCompanies(CompaniesDTO companiesDTO) {

        if (companiesRepository.existsByEmail(companiesDTO.getEmail())){
            throw new ResourceNotFoundException(String.format(Message.EMAIL_IS_USED, companiesDTO.getEmail()));
        }

        if (companiesRepository.existsByPhone(companiesDTO.getPhone())){
            throw new ResourceNotFoundException(String.format(Message.PHONE_IS_USED, companiesDTO.getPhone()));
        }
        Companies companies=companiesMapper.matToCompanies(companiesDTO);
        companiesRepository.save(companies);
    }

    public void deleteAccount(Long id) {
        if (!companiesRepository.existsById(id)){
            throw new ResourceNotFoundException(String.format(Message.ID_NOT_FOUND,id));
        }
        companiesRepository.deleteById(id);
    }

    public ResponseEntity<CompaniesDTO> findByEmail(String email) {
        Companies companies=companiesRepository.findByEmail(email).orElseThrow(()->
                new ResourceNotFoundException(String.format(Message.EMAIL_NOT_FOUND,email)));
        return ResponseEntity.ok(companiesMapper.mapToDTO(companies));
    }
=======
    public void saveCompanies(Companies companies) {

        if (companiesRepository.existsByEmail(companies.getEmail())){
            throw new ResourceNotFoundException("email daha önce kullanılmış");
        }

        if (companiesRepository.existsByPhone(companies.getPhone())){
            throw new ResourceNotFoundException("phone daha önce kullanılmış");
        }

        companiesRepository.save(companies);
    }
>>>>>>> 4fe559f0622e64e3e0b08ca0f5f06835d2ae47ee
}
