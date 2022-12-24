package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents a data access object for roles.
 * This interface extends the JpaRepository interface and defines a custom method for interacting with a database of roles.
 */
public interface RoleDao extends JpaRepository<Role, Long> {

    /**
     * Retrieves a role from the database based on its name.
     *
     * @param name the name of the role to retrieve
     * @return a Role object representing the role with the specified name, or null if no such role exists
     */
    Role findByName(String name);
}

