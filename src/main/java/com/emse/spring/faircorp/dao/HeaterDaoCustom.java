package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import java.util.List;

/**
 * Represents a custom data access object for heaters.
 * This interface defines additional methods for interacting with a database of heaters that are not provided by the JpaRepository interface.
 */
public interface HeaterDaoCustom {

    /**
     * Retrieves a list of all heaters in the database.
     *
     * @param id an unused parameter
     * @return a list of all heaters in the database
     */
    List<Heater> findAllHeaters(Long id);

    /**
     * Retrieves a list of all heaters in a given room.
     *
     * @param roomId the ID of the room whose heaters should be retrieved
     * @return a list of all heaters in the specified room
     */
    List<Heater> findAllHeatersByRoomId(Long roomId);

    /**
     * Retrieves a list of all heaters in the database, along with the rooms that they belong to.
     *
     * @return a list of all heaters in the database, along with their associated rooms
     */
    List<Heater> findAllHeatersAndRooms();
}

