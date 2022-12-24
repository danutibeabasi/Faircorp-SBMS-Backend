package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

/**
 * Provides custom data access functionality for Window entities.
 */
public interface WindowDaoCustom {

    /**
     * Retrieves a list of open Window entities associated with the specified room.
     *
     * @param id the ID of the room whose open Window entities should be retrieved
     * @return a list of open Window entities associated with the specified room
     */
    List<Window> findRoomOpenWindows(Long id);

    /**
     * Retrieves a list of all Window entities associated with the specified room.
     *
     * @param roomId the ID of the room whose associated Window entities should be retrieved
     * @return a list of all Window entities associated with the specified room
     */
    List<Window> findAllWindowsByRoomId(Long roomId);

    /**
     * Retrieves a list of all Window entities and their associated Room entities.
     *
     * @return a list of all Window entities and their associated Room entities
     */
    List<Window> findAllWindowsAndRooms();
}

