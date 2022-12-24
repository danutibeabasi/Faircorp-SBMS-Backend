package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * A domain object representing a building.
 */
@Entity
public class Building {

    /** The unique identifier for the building. */
    @Id
    @GeneratedValue
    private Long id;

    /** The name of the building. */
    @Column(nullable = false)
    private String name;

    /** The rooms in the building. */
    @OneToMany(mappedBy = "building", cascade = CascadeType.REMOVE)
    private Set<Room> rooms;

    /**
     * Constructs a new Building object with default values.
     */
    public Building() {
    }

    /**
     * Constructs a new Building object and initializes the name field with the given value.
     *
     * @param name the name of the building
     */
    public Building(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier for the building.
     *
     * @return the building's unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the building.
     *
     * @param id the building's unique identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the building.
     *
     * @return the building's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the building.
     *
     * @param name the building's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the rooms in the building.
     *
     * @return a set of rooms in the building
     */
    public Set<Room> getRoom() {
        return rooms;
    }

    /**
     * Returns the rooms in the building.
     *
     * @return a collection of rooms in the building
     */
    public Collection<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets the rooms in the building.
     *
     * @param rooms a list of rooms in the building
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = (Set<Room>) rooms;
    }
}



