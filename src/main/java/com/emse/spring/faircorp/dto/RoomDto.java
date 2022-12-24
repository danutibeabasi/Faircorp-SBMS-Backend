package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;


import java.util.Set;
import java.util.stream.Collectors;


public class RoomDto {

    /** The unique identifier for this room. */
    private Long id;

    /** The name of this room. */
    private String name;

    /** The floor number on which this room is located. */
    private Integer floor;

    /** The current temperature of this room. */
    private Double currentTemperature;

    /** The target temperature for this room. */
    private Double targetTemperature;

    /** The name of the building that this room belongs to. */
    private String buildingName;

    /** The unique identifier for the building that this room belongs to. */
    private Long buildingId;

    /** The heaters in this room. */
    private Set<HeaterDto> heaters;

    /** The windows in this room. */
    private Set<WindowDto> windows;

    /**
     * Creates a new empty RoomDto object.
     */
    public RoomDto() {
    }

    /**
     * Creates a new RoomDto object and initializes its fields using the given Room object.
     *
     * @param room the Room object to use for initialization
     */
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.floor = room.getFloor();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.buildingId = room.getBuilding().getId();
        if (room.getHeaters() != null) {
            this.heaters = room.getHeaters().stream().map(HeaterDto::new).collect(Collectors.toSet());        }
        if (room.getWindows() != null) {
            this.windows = room.getWindows().stream().map(WindowDto::new).collect(Collectors.toSet());
        }
    }

    /**
     * Returns the unique identifier for this room.
     *
     * @return the unique identifier for this room
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this room.
     *
     * @param id the new unique identifier for this room
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of this room.
     *
     * @return the name of this room
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this room.
     *
     * @param name the new name for this room
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the floor number on which this room is located.
     *
     * @return the floor number on which this room is located
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * Sets the floor number on which this room is located.
     *
     * @param floor the new floor number for this room
     */
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    /**
     * Returns the unique identifier for the building that this room belongs to.
     *
     * @return the unique identifier for the building that this room belongs to
     */
    public Long getBuildingId() {
        return buildingId;
    }

    /**
     * Sets the unique identifier for the building that this room belongs to.
     *
     * @param buildingId the new unique identifier for the building that this room belongs to
     */
    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * Returns the name of the building that this room belongs to.
     *
     * @return the name of the building that this room belongs to
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the name of the building that this room belongs to.
     *
     * @param buildingName the new name for the building that this room belongs to
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * Returns the current temperature of this room.
     *
     * @return the current temperature of this room
     */
    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    /**
     * Sets the current temperature of this room.
     *
     * @param currentTemperature the new current temperature for this room
     */
    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    /**
     * Returns the target temperature for this room.
     *
     * @return the target temperature for this room
     */
    public Double getTargetTemperature() {
        return targetTemperature;
    }

    /**
     * Sets the target temperature for this room.
     *
     * @param targetTemperature the new target temperature for this room
     */
    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    /**
     * Returns the heaters in this room.
     *
     * @return the heaters in this room
     */
    public Set<HeaterDto> getHeaters() {
        return heaters;
    }

    /**
     * Sets the heaters in this room.
     *
     * @param heaters the new heaters for this room
     */
    public void setHeaters(Set<HeaterDto> heaters) {
        this.heaters = heaters;
    }

    /**
     * Returns the windows in this room.
     *
     * @return the windows in this room
     */
    public Set<WindowDto> getWindows() {
        return windows;
    }



    public void setWindows(Set<WindowDto> windows) {
        this.windows = windows;
    }






}
