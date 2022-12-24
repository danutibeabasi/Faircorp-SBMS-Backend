package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

/**
 * A domain object representing a user role.
 */
@Entity
public class Role {
    /** The unique identifier for the role. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The name of the role. */
    private String name;

    /** The users that have this role. */
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    /**
     * Constructs a new Role object with default values.
     */
    public Role() {
    }

    /**
     * Constructs a new Role object and initializes the id and name fields with the given values.
     *
     * @param id the unique identifier for the role
     * @param name the name of the role
     */
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the unique identifier for the role.
     *
     * @return the role's unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the role.
     *
     * @param id the role's unique identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the role.
     *
     * @return the role's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     *
     * @param name the role's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the users that have this role.
     *
     * @return the users that have this role
     */
    public Set<User> getUsers() {
        return users;
    }
    /**
     * Sets the users that have this role.
     *
     * @param users the users that have this role
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
