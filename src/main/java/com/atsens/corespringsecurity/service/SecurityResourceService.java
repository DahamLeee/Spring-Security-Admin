package com.atsens.corespringsecurity.service;

import com.atsens.corespringsecurity.domain.entity.Resources;
import com.atsens.corespringsecurity.domain.entity.Role;
import com.atsens.corespringsecurity.repository.ResourcesRepository;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SecurityResourceService {

    private ResourcesRepository resourcesRepository;

    public SecurityResourceService(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getResourceList() {

        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> result = new LinkedHashMap<>();
        List<Resources> resourcesList = resourcesRepository.findAllResources();

        for (Resources resources : resourcesList) {
            List<ConfigAttribute> configAttributeList = new ArrayList<>();
            for (Role role : resources.getRoleSet()) {
                configAttributeList.add(new SecurityConfig(role.getRoleName()));
                result.put(new AntPathRequestMatcher(resources.getResourceName()), configAttributeList);
            }
        }
        return result;
    }
}
