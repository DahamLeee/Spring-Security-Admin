package com.atsens.corespringsecurity.service.impl;

import com.atsens.corespringsecurity.domain.entity.RoleHierarchy;
import com.atsens.corespringsecurity.repository.RoleHierarchyRepository;
import com.atsens.corespringsecurity.service.RoleHierarchyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    @Autowired
    private RoleHierarchyRepository roleHierarchyRepository;

    @Transactional
    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuilder concatRoles = new StringBuilder();

        while (itr.hasNext()) {
            RoleHierarchy roleHierarchy = itr.next();
            if (roleHierarchy.getParentName() != null) {
                concatRoles.append(roleHierarchy.getParentName().getChildName());
                concatRoles.append(" > ");
                concatRoles.append(roleHierarchy.getChildName());
                concatRoles.append("\n");
            }
        }

        return concatRoles.toString();
    }
}
