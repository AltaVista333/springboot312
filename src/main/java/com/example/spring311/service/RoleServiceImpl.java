package com.example.spring311.service;

import com.example.spring311.model.Role;
import com.example.spring311.repository.RoleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Role> getAllRoles() {
        return repository.findAll();
    }

    @Override
    public Role getRole(String userRole) {
        return repository.getRoleByUserRole(userRole);
    }
}
