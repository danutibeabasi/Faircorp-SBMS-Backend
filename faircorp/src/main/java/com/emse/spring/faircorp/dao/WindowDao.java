package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WindowDao extends JpaRepository<Window,Long>, WindowDaoCustom {
    Optional<Window> findById(Long id);

    @Modifying
    @Query(value = "Delete from Window w where w.room.id = ?1")
    void deleteAllByRoom(Long id);


    @Modifying
    @Query(value = "update Window w set w.windowStatus =:windowStatus where w.room.id =:roomId")
    void updateWindowStatus(@Param("roomId") Long roomId, @Param("windowStatus") WindowStatus windowStatus);
}
