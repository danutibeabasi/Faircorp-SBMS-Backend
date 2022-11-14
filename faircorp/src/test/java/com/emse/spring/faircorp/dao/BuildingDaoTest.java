package com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Room;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class BuildingDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private WindowDao windowDao;
    @Autowired
    private BuildingDao buildingDao;


    @Test
    public void shouldFindARoom(){
        Room room = roomDao.getReferenceById(-10L);
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
        Assertions.assertThat(room.getFloor()).isEqualTo(1);
        Assertions.assertThat(room.getBuilding().getName()).isEqualTo("Building1");
    }

    @Test
    public void shouldFindAllRooms(){
        Assertions.assertThat(roomDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindAllBuildings(){
        Assertions.assertThat(buildingDao.findAll().size()).isEqualTo(2);
    }

    @Test
    public void shouldFindAllWindows(){
        Assertions.assertThat(windowDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindAllHeaters(){
        Assertions.assertThat(heaterDao.findAll().size()).isEqualTo(2);
    }

    @Test
    public void shouldDeleteAWindow(){
        windowDao.deleteById(-10L);
        Assertions.assertThat(windowDao.findAll().size()).isEqualTo(3);
    }

    @Test
    public void shouldDeleteAHeater(){
        heaterDao.deleteById(-10L);
        Assertions.assertThat(heaterDao.findAll().size()).isEqualTo(1);
    }

}