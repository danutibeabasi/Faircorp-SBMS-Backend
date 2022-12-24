package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Provides concrete implementations for custom data access functionality for rooms.
 * This class implements methods defined in the RoomDaoCustom interface.
 */
public class RoomDaoCustomImpl implements RoomDaoCustom {

    /**
     * An EntityManager object used to create and execute database queries.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieves a single room from the database based on its ID.
     *
     * @param id the ID of the room to retrieve
     * @return a list of rooms with the specified ID
     */
    @Override
    public List<Room> findRoomById(Long id) {
        String jpql = "SELECT r FROM Room r WHERE r.id = :value";
        return em.createQuery(jpql, Room.class)
                .setParameter("value", id)
                .getResultList();
    }

    /**
     * Retrieves a list of rooms from the database that belong to a given building.
     *
     * @param buildingId the ID of the building whose rooms should be retrieved
     * @return a list of rooms that belong to the building with the specified ID
     */
    @Override
    public List<Room> findRoomsByBuildingId(Long buildingId) {
        String JPQL = "SELECT r FROM Room r WHERE r.building.id = :value";
        return em.createQuery(JPQL, Room.class)
                .setParameter("value", buildingId)
                .getResultList();
    }
}
