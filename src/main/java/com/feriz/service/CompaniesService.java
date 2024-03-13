package com.feriz.service;

import com.feriz.domain.Companies;

import com.feriz.dto.CompaniesDTO;
import com.feriz.dto.business.response.ResponseMessage;
import com.feriz.exceptions.ConflictException;
import com.feriz.exceptions.ResourceNotFoundException;
import com.feriz.mapper.CompaniesMapper;
import com.feriz.messages.Message;
import com.feriz.repository.AccountRepository;
import com.feriz.repository.CompaniesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

        checkEmail(companiesDTO.getEmail());
        checkPhone(companiesDTO.getPhone());
        Companies companies=companiesMapper.mapToCompanies(companiesDTO);
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


    public ResponseMessage<CompaniesDTO> update(Long companiesId, CompaniesDTO companiesDTO) {
        Companies companies = findCompaniesById(companiesId);

        if (!companies.getPhone().equals(companiesDTO.getPhone())) {
            checkPhone(companiesDTO.getPhone());
        }
        if (!companies.getEmail().equals(companiesDTO.getEmail())) {
            checkEmail(companiesDTO.getEmail());
        }
        Companies companiesUpdated = companiesMapper.mapToUpdatedCompanies(companiesId, companiesDTO);
        companiesRepository.save(companiesUpdated);

        return ResponseMessage.<CompaniesDTO>builder()
                .message(Message.UPDATED_SUCCESFULLY)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    private Companies findCompaniesById(Long id){
        return companiesRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(Message.ID_NOT_FOUND));
    }

    private void checkEmail(String email){
        if (companiesRepository.existsByEmail(email)){
            throw new ConflictException(Message.EMAIL_IS_USED);
        }
    }
    private void checkPhone(String phone){
        if (companiesRepository.existsByPhone(phone)){
            throw new ConflictException(Message.PHONE_IS_USED);
        }
    }



}
