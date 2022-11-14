package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
