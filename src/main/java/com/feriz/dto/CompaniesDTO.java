package com.feriz.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CompaniesDTO {

    @NotBlank(message = "Lütfen name giriniz")
    private String name;
    @NotNull(message = "Lütfen geçerli bir telefon numarası giriniz")
    private String phone;
    @NotNull(message = "Lütfen geçerli bir email giriniz")
    private String email;
}
