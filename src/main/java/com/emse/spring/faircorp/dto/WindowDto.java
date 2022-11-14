package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private Long room_Id;

    private String room_Name;
    private WindowStatus status;

    public WindowDto() {
    }

    public WindowDto(Long id, String name, Long room_Id, String room_Name, WindowStatus status) {
        this.id = id;
        this.name = name;
        this.room_Name = room_Name;
        this.room_Id = room_Id;
        this.status = status;
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.room_Id = window.getRoom_window().getId();
        this.room_Name = window.getRoom_window().getName();
        this.status = window.getWindowStatus();
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

    public WindowStatus getWindowStatus() {
        return status;
    }

    public void setStatus(WindowStatus status) {
        this.status = status;
    }

    public Long getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(Long room_Id) {
        this.room_Id = room_Id;
    }

    public String getRoom_Name() {
        return room_Name;
    }
    public void setRoom_Name(String room_Name) {
        this.room_Name = room_Name;
    }

    public Long getRoomId() {
        return room_Id;
    }
}
