package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Heater> findAllHeaters(Long id) {
        String jpql = "select h from Heater h where h.room.id = :id and h.heaterStatus= :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }

    @Override
    public List<Heater> findAllHeatersByRoomId(Long roomId) {
        String jpql = "select h from Heater h where h.room.id = :id and h.heaterStatus= :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", roomId)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }

    @Override
    public List<Heater> findAllHeatersAndRooms() {
        String jpql = "select h from Heater h, Room r, Building b where h.room.id = r.id and r.building.id = b.id";
        return em.createQuery(jpql, Heater.class)
                .getResultList();

    }



}
