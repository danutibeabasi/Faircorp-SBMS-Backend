package com.emse.spring.faircorp.model;

import javax.persistence.*;

/**
 * A domain object representing a heater.
 */
@Entity
@Table(name = "Heater")
public class Heater {

    /** The unique identifier for the heater. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** The name of the heater. */
    @Column(nullable = false)
    private String name;

    /** The power of the heater, in watts. */
    private Long power;

    /** The room that the heater belongs to. */
    @ManyToOne(optional = false)
    private Room room;

    /** The current status of the heater. */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus heaterStatus;

    /**
     * Constructs a new Heater object with default values.
     */
    public Heater(String heater1, int i, HeaterStatus on, double v, Room room) {
    }

    /**
     * Constructs a new Heater object and initializes the name, room, heaterStatus, and power fields with the given values.
     *
     * @param name the name of the heater
     * @param room the room that the heater belongs to
     * @param heaterStatus the current status of the heater
     * @param power the power of the heater, in watts
     */
    public Heater(String name, Room room, HeaterStatus heaterStatus, Long power) {
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
        this.power = power;
    }

    public Heater(String s, int i, Room room) {
    }

    /**
     * Returns the unique identifier for the heater.
     *
     * @return the heater's unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the heater.
     *
     * @param id the heater's unique identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the heater.
     *
     * @return the heater's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the heater.
     *
     * @param name the heater's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the power of the heater, in watts.
     *
     * @return the heater's power, in watts
     */
    public Long getPower() {
        return power;
    }

    /**
     * Sets the power of the heater, in watts.
     *
     * @param power the heater's power, in watts
     */
    public void setPower(Long power) {
        this.power = power;
    }

    /**
     * Returns the room that the heater belongs to.
     *
     * @return the room that the heater belongs to
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room that the heater belongs to.
     *
     * @param room the room that the heater belongs to
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Returns the current status of the heater.
     *
     * @return the heater's current status
     */
    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    /**
     * Sets the current status of the heater.
     *
     * @param heaterStatus the heater's current status
     */
    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
