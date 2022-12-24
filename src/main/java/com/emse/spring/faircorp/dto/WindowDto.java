package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

/**
 * A class representing a data transfer object for a Window object.
 *
 */
public class WindowDto {

    /**
     * The unique identifier of the window.
     */
    private Long id;

    /**
     * The name of the window.
     */
    private String name;

    /**
     * The unique identifier of the room that the window belongs to.
     */
    private Long room_Id;

    /**
     * The name of the room that the window belongs to.
     */
    private String room_Name;

    /**
     * The status of the window (open or closed).
     */
    private WindowStatus status;

    /**
     * Constructs a new WindowDto object with no initial values for the fields.
     */
    public WindowDto() {
    }

    /**
     * Constructs a new WindowDto object and initializes all of its fields.
     *
     * @param id the unique identifier of the window
     * @param name the name of the window
     * @param room_Id the unique identifier of the room that the window belongs to
     * @param room_Name the name of the room that the window belongs to
     * @param status the status of the window
     */
    public WindowDto(Long id, String name, Long room_Id, String room_Name, WindowStatus status) {
        this.id = id;
        this.name = name;
        this.room_Name = room_Name;
        this.room_Id = room_Id;
        this.status = status;
    }

    /**
     * Constructs a new WindowDto object from the properties of a Window object.
     *
     * @param window the Window object to create the WindowDto object from
     */
    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.room_Id = window.getRoom().getId();
        this.room_Name = window.getRoom().getName();
        this.status = window.getWindowStatus();
    }

    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public WindowStatus getWindowStatus() {
        return status;
    }

    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public void setStatus(WindowStatus status) {
        this.status = status;
    }


    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public void setRoom_Id(Long room_Id) {
        this.room_Id = room_Id;
    }

    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public String getRoom_Name() {
        return room_Name;
    }

    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public void setRoom_Name(String room_Name) {
        this.room_Name = room_Name;
    }

    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public Long getRoomId() {
        return room_Id;
    }
    /**
     * Returns the unique identifier of the window.
     *
     * @return the unique identifier of the window
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the window.
     *
     * @param id the new unique identifier for the window
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the window.
     *
     * @return the name of the window
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the window.
     *
     * @param name the new name for the window
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the unique identifier of the room that the window belongs to.
     *
     * @return the unique identifier of the room that the window belongs to
     */
    public Long getRoom_Id() {
        return room_Id;
    }
}
