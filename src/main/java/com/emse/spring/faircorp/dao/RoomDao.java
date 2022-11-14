package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

public interface RoomDao extends JpaRepository<Room, Long> {
    Optional<Room> findById(Long id);
    List<Room> findByBuildingId(Long buildingId);

    @Modifying
    @Query(value = "delete from Room r where r.id = ?1")
    IntPredicate deleteRoom(Long id);
}
