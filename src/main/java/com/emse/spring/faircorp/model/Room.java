package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;


    private Double currentTemperature;

    private Double targetTemperature;

    @OneToMany(mappedBy = "room" , cascade = CascadeType.REMOVE)
    private List<Heater> heaters;

    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE)
    private List<Window> windows;

    @ManyToOne
    private Building building;

    public Room(Integer floor, String name, Double currentTemperature, Double targetTemperature, Building building) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.building = building;
    }

    public Room(String s, int i) {
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Room() {
    }

    public Room(String name, Integer floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }


    public Room(Long id, Long building, String name, int floor, Double currentTemperature, Double targetTemperature, List<Heater> heaters, List<Window> windows) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.heaters = heaters;
        this.windows = windows;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }
}
