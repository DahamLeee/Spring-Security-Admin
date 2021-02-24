package com.atsens.corespringsecurity.domain.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AccountDto {

    private String id;
    private String username;
    private String email;
    private int age;
    private String password;
    private List<String> roles;
}
