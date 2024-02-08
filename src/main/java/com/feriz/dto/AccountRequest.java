package com.feriz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    @NotBlank(message = "lütfen geçerli name girin")
    private String firstName;

    @NotBlank(message = "lütfen geçerli lastname girin")
    private String lastName;

    @NotBlank(message = "lütfen geçerli username girin")
    private String userName;

    @NotBlank(message = "lütfen geçerli password girin")
    private String password;

    @Email
    @NotBlank(message = "lütfen geçerli email girin")
    private String email;
}
