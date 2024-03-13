package com.feriz.mapper;

import com.feriz.domain.Companies;
import com.feriz.dto.CompaniesDTO;
import org.springframework.stereotype.Component;

@Component
public class CompaniesMapper {


    public CompaniesDTO mapToDTO(Companies companies){

        return CompaniesDTO.builder().
                name(companies.getName()).
                phone(companies.getPhone()).
                email(companies.getEmail()).build();


    }

    public Companies mapToCompanies(CompaniesDTO companiesDTO){
        return Companies.builder()
                .name(companiesDTO.getName())
                .phone(companiesDTO.getPhone())
                .email(companiesDTO.getEmail()).build();
    }

    public Companies mapToUpdatedCompanies(Long companiesId,CompaniesDTO companiesDTO){
        return Companies.builder()
                .id(companiesId)
                .name(companiesDTO.getName())
                .phone(companiesDTO.getPhone())
                .email(companiesDTO.getEmail())
                .build();
    }

}


//@Component
//public class CompanyMapper {
//
//    public CompanyDTO mapToDTO(Companies company) {
//        CompanyDTO dto = new CompanyDTO();
//        dto.setId(company.getId());
//        dto.setName(company.getName());
//        dto.setDescription(company.getDescription());
//        // Diğer alanları da doldurabilirsiniz...
//        return dto;
//    }
//
//    // Gerekirse diğer yönlendirme yöntemlerini ekleyebilirsiniz.
//}