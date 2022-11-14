package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Room> findRoomById(Long id) {
        String jpql = "select r from Room r where r.id = :value";
        return em.createQuery(jpql, Room.class)
                .setParameter("value", id)
                .getResultList();

            }

    @Override
    public List<Room> findRoomsByBuildingId(Long buildingId) {
        String JPQL = "select r from Room r where r.building.id = :value";
        return em.createQuery(JPQL, Room.class)
                .setParameter("value", buildingId)
                .getResultList();
    }


}