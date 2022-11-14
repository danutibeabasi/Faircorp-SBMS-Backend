package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "Heater")
public class Heater {

    public static Object Status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

    private Long power;

    @ManyToOne(optional = false)
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus heaterStatus;

    public Heater() {
    }

    public Heater(String name, Room room, HeaterStatus heaterStatus, Long power) {
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }
}
