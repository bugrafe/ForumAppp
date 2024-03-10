package com.feriz.service;

import com.feriz.domain.Companies;
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

@Service
@RequiredArgsConstructor
public class CompaniesService {

    private final CompaniesRepository companiesRepository;
    private final AccountRepository accountRepository;
    private final CompaniesMapper companies;
    private final CompaniesMapper companiesMapper;



    public List<Companies> getAllListCompanies() {
        return companiesRepository.findAll();
    }

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
}
