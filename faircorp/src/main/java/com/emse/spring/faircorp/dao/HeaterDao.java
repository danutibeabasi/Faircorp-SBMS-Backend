package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HeaterDao extends JpaRepository<Heater,Long>, HeaterDaoCustom {
     Optional<Heater> findById(Long id);

    @Modifying
    @Query(value = "Delete from Heater h where h.room.id = ?1")
    void deleteAllByRoom(Long id);


    @Modifying
    @Query(value = "update Heater h set h.heaterStatus =:heaterStatus where h.room.id =:roomId")
    void updateHeaterStatus(@Param("roomId") Long roomId, @Param("heaterStatus") HeaterStatus heaterStatus);





}
