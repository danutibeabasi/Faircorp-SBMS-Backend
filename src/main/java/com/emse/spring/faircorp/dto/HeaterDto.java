package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

/**
 * A data transfer object (DTO) for a heater.
 *
 */
public class HeaterDto {
    /**
     * The unique identifier of the heater.
     */
    private Long id;
    /**
     * The name of the heater.
     */
    private String name;
    /**
     * The unique identifier of the room that the heater belongs to.
     */
    private Long room_Id;
    /**
     * The current status of the heater.
     */
    private HeaterStatus heaterStatus;
    /**
     * The power consumption of the heater.
     */
    private Long power;

    /**
     * Constructor for the HeaterDto class that takes an instance of a Heater object as an argument.
     *
     * @param heater the instance of the Heater object
     */
    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.room_Id = heater.getRoom().getId();
        this.heaterStatus = heater.getHeaterStatus();
    }

    /**
     * Returns the unique identifier of the heater.
     *
     * @return the id of the heater
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the heater.
     *
     * @param id the id of the heater
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the heater.
     *
     * @return the name of the heater
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the heater.
     *
     * @param name the name of the heater
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the room that the heater belongs to.
     *
     * @return the id of the room
     */
    public Long getRoom_Id() {
        return room_Id;
    }

    /**
     * Sets the unique identifier of the room that the heater belongs to.
     *
     * @param room_Id the id of the room
     */
    public void setRoom_Id(Long room_Id) {
        this.room_Id = room_Id;
    }

    /**
     * Returns the current status of the heater.
     *
     * @return the status of the heater
     */
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    /**
     * Sets the current status of the heater.
     *
     * @param heaterStatus the status of the heater
     */
    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    /**
     * Returns the power consumption of the heater.
     *
     * @return the power of the heater
     */
    public Long getPower() {
        return power;
    }
}
