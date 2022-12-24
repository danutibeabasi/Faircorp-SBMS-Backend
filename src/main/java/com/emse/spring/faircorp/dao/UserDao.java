package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents a data access object for users.
 * This interface extends the JpaRepository interface and provides basic CRUD operations for users.
 */
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * Retrieves a user from the database based on their username.
     *
     * @param username the username of the user to retrieve
     * @return the user with the specified username, or null if no such user exists
     */
    User findByUsername(String username);
}

