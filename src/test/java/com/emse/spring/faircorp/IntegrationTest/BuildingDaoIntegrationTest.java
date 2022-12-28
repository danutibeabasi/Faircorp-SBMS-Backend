package com.emse.spring.faircorp.IntegrationTest;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class BuildingDaoIntegrationTest {

    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private WindowDao windowDao;
    @Autowired
    private BuildingDao buildingDao;

    @Test
    public void shouldFindARoom() {
        Room room = roomDao.getReferenceById(-10L);
        assertThat(room.getName()).isEqualTo("Room1");
        assertThat(room.getFloor()).isEqualTo(1);
        assertThat(room.getBuilding().getName()).isEqualTo("Building1");
    }

    @Test
    public void shouldFindAllRooms() {
        assertThat(roomDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindAllBuildings() {
        assertThat(buildingDao.findAll().size()).isEqualTo(2);
    }

    @Test
    public void shouldFindAllWindows() {
        assertThat(windowDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldFindAllHeaters() {
        assertThat(heaterDao.findAll().size()).isEqualTo(2);
    }

    @Test
    public void shouldDeleteAWindow() {
        windowDao.deleteById(-10L);
        assertThat(windowDao.findAll().size()).isEqualTo(3);
    }

    @Test
    public void shouldDeleteAHeater() {
        heaterDao.deleteById(-10L);
        assertThat(heaterDao.findAll().size()).isEqualTo(1);
    }
}
