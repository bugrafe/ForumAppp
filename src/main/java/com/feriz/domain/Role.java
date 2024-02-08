package com.feriz.domain;

import com.feriz.domain.enums.AccountRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 30,nullable = false)
    private AccountRole name;

    @Override
    public String toString() {
        return "Role{" +
                "accountRole=" + name +
                '}';
    }
}
