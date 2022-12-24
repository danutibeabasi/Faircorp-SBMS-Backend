package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Represents a data access object for heaters.
 * This interface extends the JpaRepository interface and defines custom methods for interacting with a database of heaters.
 */
public interface HeaterDao extends JpaRepository<Heater, Long>, HeaterDaoCustom {

    /**
     * Retrieves a heater from the database based on its ID.
     *
     * @param id the ID of the heater to retrieve
     * @return an Optional object containing the requested heater, or an empty Optional if no such heater exists
     */
    Optional<Heater> findById(Long id);

    /**
     * Deletes all heaters that belong to a given room from the database.
     *
     * @param id the ID of the room whose heaters should be deleted
     */
    @Modifying
    @Query(value = "DELETE FROM Heater h WHERE h.room.id = ?1")
    void deleteAllByRoom(Long id);

    /**
     * Updates the status of all heaters in a given room.
     *
     * @param roomId the ID of the room whose heaters should be updated
     * @param heaterStatus the new status for the heaters
     */
    @Modifying
    @Query(value = "UPDATE Heater h SET h.heaterStatus =:heaterStatus WHERE h.room.id =:roomId")
    void updateHeaterStatus(@Param("roomId") Long roomId, @Param("heaterStatus") HeaterStatus heaterStatus);
}

