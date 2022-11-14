package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {

    private Long id;
    private String name;

    public BuildingDto(){
    }

    public BuildingDto(Building building){
        this.id = building.getId();
        this.name = building.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
