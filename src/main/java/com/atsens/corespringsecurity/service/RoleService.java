package com.atsens.corespringsecurity.service;

import com.atsens.corespringsecurity.domain.entity.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}
