package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

/**
 * A domain object representing a room in a building.
 */
@Entity
public class Room {
    /** The unique identifier for the room. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The name of the room. */
    @Column(nullable = false)
    private String name;

    /** The floor on which the room is located. */
    @Column(nullable = false)
    private Integer floor;

    /** The current temperature of the room. */
    private Double currentTemperature;

    /** The target temperature for the room. */
    private Double targetTemperature;

    /** The heaters in the room. */
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Heater> heaters;

    /** The windows in the room. */
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Window> windows;

    /** The building in which the room is located. */
    @ManyToOne
    private Building building;


    /**
     * Constructs a new Room object with the given values.
     *
     * @param floor the floor on which the room is located
     * @param name the name of the room
     * @param currentTemperature the current temperature of the room
     * @param targetTemperature the target temperature for the room
     * @param building the building in which the room is located
     */
    public Room(Integer floor, String name, Double currentTemperature, Double targetTemperature, Building building) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.building = building;
    }

    /**
     * Constructs a new Room object with the given values.
     *
     * @param name the name of the room
     * @param floor the floor on which the room is located
     * @param building the building in which the room is located
     */
    public Room(String name, Integer floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }

    /**
     * Constructs a new Room object with the given values.
     *
     * @param id the unique identifier for the room
     * @param building the building in which the room is located
     * @param name the name of the room
     * @param floor the floor on which the room is located
     * @param currentTemperature the current temperature of the room
     * @param targetTemperature the target temperature for the room
     * @param heaters the heaters in the room
     * @param windows the windows in the room
     */
    public Room(Long id, Long building, String name, int floor, Double currentTemperature, Double targetTemperature, List<Heater> heaters, List<Window> windows) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.heaters = heaters;
        this.windows = windows;
    }


    public Room(String name, Integer floor) {
        this.name = name;
        this.floor = floor;

    }

    public Room(){

    }

    public Room(String s, int i, int i1, int i2) {
    }

    /**
     * Returns the unique identifier for the room.
     *
     * @return the unique identifier for the room
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the room.
     *
     * @param id the unique identifier for the room
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the room.
     *
     * @param name the name of the room
     */
    public Building getBuilding() {
        return building;
    }

    /**
     * Sets the building of the room.
     *
     * @param building the building of the room
     */
    public void setBuilding(Building building) {
        this.building = building;
    }


    /**
     * Sets the name of the room.
     *
     * @param name the name of the room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the floor on which the room is located.
     *
     * @return the floor on which the room is located
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Sets the floor on which the room is located.
     *
     * @param floor the floor on which the room is located
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }


    /**
     * Returns the current temperature of the room.
     *
     * @return the current temperature of the room
     */
    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * Sets the current temperature of the room.
     *
     * @param currentTemperature the current temperature of the room
     */
    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    /**
     * Returns the target temperature for the room.
     *
     * @return the target temperature for the room
     */
    public Double getTargetTemperature() {
        return targetTemperature;
    }

    /**
     * Sets the target temperature for the room.
     *
     * @param targetTemperature the target temperature for the room
     */
    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    /**
     * Returns the heaters in the room.
     *
     * @return the heaters in the room
     */
    public List<Heater> getHeaters() {
        return heaters;
    }

    /**
     * Sets the heaters in the room.
     *
     * @param heaters the heaters in the room
     */
    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    /**
     * Returns the windows in the room.
     *
     * @return the windows in the room
     */
    public List<Window> getWindows() {
        return windows;
    }

    /**
     * Sets the windows in the room.
     *
     * @param windows the windows in the room
     */
    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }
}
