package com.atsens.corespringsecurity.domain.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RoleDto {

    private String id;
    private String roleName;
    private String roleDesc;
}
