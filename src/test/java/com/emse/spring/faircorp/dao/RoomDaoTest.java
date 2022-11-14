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
class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;



    @Test
    public void shouldFindARoom(){
        Room Room = roomDao.getReferenceById(-10L);
        Assertions.assertThat(Room.getName()).isEqualTo("Room1");
        Assertions.assertThat(Room.getCurrentTemperature()).isEqualTo(22.3);
    }

    @Test
    public void shouldFindAllRooms(){
        Assertions.assertThat(roomDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindAllRoomsByBuildingId(){
        Assertions.assertThat(roomDao.findByBuildingId(-10L).size()).isEqualTo(2);

    }
}