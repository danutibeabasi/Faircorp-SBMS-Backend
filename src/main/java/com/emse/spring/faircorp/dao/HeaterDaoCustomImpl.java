package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Provides concrete implementations for the custom methods defined in the HeaterDaoCustom interface.
 */
public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    // EntityManager is used to create and execute database queries
    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieves a list of all heaters in the database that belong to a given room and have a status of ON.
     *
     * @param id the ID of the room whose heaters should be retrieved
     * @return a list of all heaters in the specified room with a status of ON
     */
    @Override
    public List<Heater> findAllHeaters(Long id) {
        String jpql = "SELECT h FROM Heater h WHERE h.room.id = :id AND h.heaterStatus = :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }

    /**
     * Retrieves a list of all heaters in a given room that have a status of ON.
     *
     * @param roomId the ID of the room whose heaters should be retrieved
     * @return a list of all heaters in the specified room with a status of ON
     */
    @Override
    public List<Heater> findAllHeatersByRoomId(Long roomId) {
        String jpql = "SELECT h FROM Heater h WHERE h.room.id = :id AND h.heaterStatus = :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", roomId)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }

    /**
     * Retrieves a list of all heaters in the database, along with the rooms and buildings that they belong to.
     *
     * @return a list of all heaters in the database, along with their associated rooms and buildings
     */
    @Override
    public List<Heater> findAllHeatersAndRooms() {
        String jpql = "SELECT h FROM Heater h, Room r, Building b WHERE h.room.id = r.id AND r.building.id = b.id";
        return em.createQuery(jpql, Heater.class)
                .getResultList();
    }
}

