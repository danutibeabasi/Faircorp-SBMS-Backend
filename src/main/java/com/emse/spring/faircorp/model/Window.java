package com.emse.spring.faircorp.model;


import javax.persistence.*;

/**
 * A class representing a window in the system.
 *
 */
@Entity
@Table(name = "RWindow")
public class Window {

    /**
     * The unique identifier of the window.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The name of the window.
     * This field is mapped to a non-nullable column in the database table.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The status of the window.
     * This field is an enumeration that is mapped to a non-nullable column in the database table,
     * and the value is stored as a string in the database.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WindowStatus windowStatus;

    /**
     * The room that the window belongs to.
     * This field represents a many-to-one relationship with the Room class.
     * It is fetched lazily, which means that when a Window object is retrieved from the database,
     * its associated Room object will not be retrieved until it is explicitly accessed.
     */
    @ManyToOne
    private Room room;

    /**
     * Constructs a new Window object with no initial values for the fields.
     */
    public Window() {
    }

    /**
     * Constructs a new Window object and initializes the name and status fields.
     *
     * @param name the name of the window
     * @param status the status of the window
     */
    public Window(String name, WindowStatus status) {
        this.windowStatus = status;
        this.name = name;
    }

    /**
     * Constructs a new Window object and initializes all of its fields.
     *
     * @param room the room that the window belongs to
     * @param name the name of the window
     * @param windowStatus the status of the window
     */
    public Window(Room room, String name, WindowStatus windowStatus) {
        this.room = room;
        this.name = name;
        this.windowStatus = windowStatus;
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
     * Returns the status of the window.
     *
     * @return the status of the window
     */
    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    /**
     * Sets the status of the window.
     *
     * @param windowStatus the new status for the window
     */
    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    /**
     * Returns the room that the window belongs to.
     *
     * @return the room that the window belongs to
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room that the window belongs to.
     *
     * @param room the new room for the window
     */
    public void setRoom(Room room) {
        this.room = room;
    }
}


