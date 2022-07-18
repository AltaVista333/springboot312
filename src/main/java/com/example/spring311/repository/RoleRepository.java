package com.example.spring311.repository;

import com.example.spring311.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByUserRole(String userRole);
}
