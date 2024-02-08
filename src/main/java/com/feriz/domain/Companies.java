package com.feriz.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 50,nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Column(length = 20,nullable = false,unique = true)
    private String phone;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate=LocalDateTime.now();


}
