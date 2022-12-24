package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

/**
 * Provides custom data access functionality for rooms.
 * This interface defines methods for interacting with a database of rooms that are not provided by the JpaRepository interface.
 */
public interface RoomDaoCustom {

    /**
     * Retrieves a single room from the database based on its ID.
     *
     * @param id the ID of the room to retrieve
     * @return a list of rooms with the specified ID
     */
    List<Room> findRoomById(Long id);

    /**
     * Retrieves a list of rooms from the database that belong to a given building.
     *
     * @param buildingId the ID of the building whose rooms should be retrieved
     * @return a list of rooms that belong to the building with the specified ID
     */
    List<Room> findRoomsByBuildingId(Long buildingId);
}

