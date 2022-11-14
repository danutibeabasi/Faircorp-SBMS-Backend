package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

public class HeaterDto {


    private Long id;

    private String name;
    private Long room_Id;
    private HeaterStatus heaterStatus;
    private Long power;

    public HeaterDto() {
    }

    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.room_Id = heater.getRoom().getId();
        this.heaterStatus = heater.getHeaterStatus();
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

    public Long getRoom_Id() {

        return room_Id;
    }

    public void setRoom_Id(Long room_Id) {

        this.room_Id = room_Id;
    }

    public HeaterStatus getHeaterStatus() {

        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {

        this.heaterStatus = heaterStatus;
    }

    public Long getPower() {
        return power;
    }
}
