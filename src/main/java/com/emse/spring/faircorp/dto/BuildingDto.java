package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;

/**
 * A data transfer object (DTO) for a building.
 *
 */
public class BuildingDto {
    /**
     * The unique identifier of the building.
     */
    private Long id;
    /**
     * The name of the building.
     */
    private String name;

    /**
     * Default constructor for the BuildingDto class.
     */
    public BuildingDto() {
    }

    /**
     * Constructor for the BuildingDto class that takes an instance of a Building object as an argument.
     *
     * @param building the instance of the Building object
     */
    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
    }

    /**
     * Returns the unique identifier of the building.
     *
     * @return the id of the building
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the name of the building.
     *
     * @return the name of the building
     */
    public String getName() {
        return name;
    }
}

