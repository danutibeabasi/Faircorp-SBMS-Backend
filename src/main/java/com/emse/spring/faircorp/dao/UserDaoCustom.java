package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Role;
import com.emse.spring.faircorp.model.User;

import java.util.List;

/**
 * Provides custom data access functionality for users.
 * This interface defines methods for interacting with a database of users and roles that are not provided by the JpaRepository interface.
 */
public interface UserDaoCustom {

    /**
     * Persists a user object to the database.
     *
     * @param user the user object to be persisted
     * @return the persisted user object
     */
    User saveUser(User user);

    /**
     * Persists a role object to the database.
     *
     * @param role the role object to be persisted
     * @return the persisted role object
     */
    Role saveRole(Role role);

    /**
     * Adds a role to a user.
     *
     * @param username the username of the user to which the role should be added
     * @param roleName the name of the role to be added
     */
    void addRoleToUser(String username, String roleName);

    /**
     * Retrieves a user from the database based on their username.
     *
     * @param username the username of the user to retrieve
     * @return the user with the specified username, or null if no such user exists
     */
    User getUser(String username);

    /**
     * Retrieves a list of all users from the database.
     *
     * @return a list of all users in the database
     */
    List<User> getUsers();
}
