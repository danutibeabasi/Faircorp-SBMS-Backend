package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public List<Window> findAllWindowsByRoomId(Long roomId) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", roomId)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }


    @Override
    public List<Window> findAllWindowsAndRooms() {
        String jpql = "select w from Window w, Room r, Building b where w.room.id = r.id and r.building.id = b.id";
        return em.createQuery(jpql, Window.class)
                .getResultList();

    }
}

