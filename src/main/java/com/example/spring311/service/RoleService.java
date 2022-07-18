package com.example.spring311.service;

import com.example.spring311.model.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRole(String userRole);
}
