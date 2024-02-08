package com.feriz.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 20,min = 2,message = "Lütfen ${min} ile ${max} arasında bir isim giriniz!")
    @Column(length = 20)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 20,min = 2,message = "Lütfen ${min} ile ${max} arasında bir soyisim giriniz!")
    @Column(length = 20)
    private String lastName;

    @NotBlank
    @NotNull
    @Size(message = "Kullanılmayan ve geçerli bir username giriniz!")
    @Column(length = 25, nullable = false, unique = true)
    private String userName;

    @NotBlank
    @NotNull
    @Column(nullable = false,length = 255)
    private String password;

    @Email
    @Column(unique = true)
    private String email;

    private LocalDateTime createDate=LocalDateTime.now();

    @JoinTable(name = "account_role",joinColumns = @JoinColumn(name = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles=new HashSet<>();




}
