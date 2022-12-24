package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Provides custom data access functionality for windows.
 * This interface extends the JpaRepository interface and the WindowDaoCustom interface to provide additional data access methods for Window entities.
 */
public interface WindowDao extends JpaRepository<Window, Long>, WindowDaoCustom {

    /**
     * Retrieves a Window entity with the specified ID from the database.
     *
     * @param id the ID of the Window entity to retrieve
     * @return an Optional object that may contain the Window entity, or may be empty if no such entity exists
     */
    Optional<Window> findById(Long id);

    /**
     * Deletes all Window entities associated with the specified room.
     *
     * @param id the ID of the room whose associated Window entities should be deleted
     */
    @Modifying
    @Query(value = "Delete from Window w where w.room.id = ?1")
    void deleteAllByRoom(Long id);

    /**
     * Updates the windowStatus field of all Window entities associated with the specified room.
     *
     * @param roomId the ID of the room whose associated Window entities should be updated
     * @param windowStatus the new value for the windowStatus field
     */
    @Modifying
    @Query(value = "update Window w set w.windowStatus =:windowStatus where w.room.id =:roomId")
    void updateWindowStatus(@Param("roomId") Long roomId, @Param("windowStatus") WindowStatus windowStatus);
}

