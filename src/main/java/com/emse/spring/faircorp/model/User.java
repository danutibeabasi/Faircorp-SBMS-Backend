package com.emse.spring.faircorp.model;

import javax.persistence.*;

/**
 * A class representing a user in the system.
 *
 */
@Entity
@Table(name = "RUSER")
public class User {

    /**
     * The unique identifier of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the user.
     * This field is mapped to a non-nullable column in the database table.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The username of the user.
     * This field is mapped to a non-nullable column in the database table.
     */
    @Column(nullable = false)
    public String username;

    /**
     * The password of the user.
     * This field is mapped to a column in the database table.
     */
    private String password;

    /**
     * The role of the user.
     * This field represents a many-to-one relationship with the Role class.
     * It is fetched eagerly, which means that when a User object is retrieved from the database,
     * its associated Role object will also be retrieved at the same time.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    /**
     * Constructs a new User object with no initial values for the fields.
     */
    public User() {
    }

    /**
     * Constructs a new User object and initializes all of its fields.
     *
     * @param id the unique identifier of the user
     * @param name the name of the user
     * @param password the password of the user
     * @param username the username of the user
     * @param role the role of the user
     */
    public User(Long id, String name, String password, String username, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    /**
     * Returns the unique identifier of the user.
     *
     * @return the unique identifier of the user
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id the new unique identifier for the user
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the role of the user.
     *
     * @return the role of the user
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the new role for the user
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Returns the name of the role of the user.
     *
     * @return the name of the role of the user
     */
    public String getRoles() {
        return role.getName();
    }
}





