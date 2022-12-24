package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

/**
 * Represents a data access object for rooms.
 * This interface extends the JpaRepository interface and defines additional methods for interacting with a database of rooms.
 */
public interface RoomDao extends JpaRepository<Room, Long> {

    /**
     * Retrieves a room from the database based on its ID.
     *
     * @param id the ID of the room to retrieve
     * @return an Optional object containing the requested room, or an empty Optional if no such room exists
     */
    Optional<Room> findById(Long id);

    /**
     * Retrieves a list of rooms from the database that belong to a given building.
     *
     * @param buildingId the ID of the building whose rooms should be retrieved
     * @return a list of rooms that belong to the building with the specified ID
     */
    List<Room> findByBuildingId(Long buildingId);

    /**
     * Deletes a room from the database.
     *
     * @param id the ID of the room to delete
     * @return a IntPredicate object representing the result of the delete operation
     */
    @Modifying
    @Query(value = "DELETE FROM Room r WHERE r.id = ?1")
    IntPredicate deleteRoom(Long id);
}

