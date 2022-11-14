package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findAllHeaters(Long id);

    List<Heater> findAllHeatersByRoomId(Long roomId);

    List<Heater> findAllHeatersAndRooms();

}
