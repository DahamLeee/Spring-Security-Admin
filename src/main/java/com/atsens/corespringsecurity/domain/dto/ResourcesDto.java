package com.atsens.corespringsecurity.domain.dto;


import com.atsens.corespringsecurity.domain.entity.Role;
import lombok.*;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ResourcesDto {

    private String id;
    private String resourceName;
    private String httpMethod;
    private int orderNum;
    private String resourceType;
    private String roleName;
    private Set<Role> roleSet;
}
