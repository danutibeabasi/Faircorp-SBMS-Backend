package com.emse.spring.faircorp.IntegrationTest;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
class WindowDaoIntegrationTest {

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getReferenceById(-10L);
        assertThat(window.getName()).isEqualTo("Window 1");
        assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.OPEN);
    }

    @Test
    public void shouldFindAllWindows() {
        Window window = windowDao.getReferenceById(-10L);
        assertThat(windowDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldDeleteWindowsRoom() {

        Room room = roomDao.getReferenceById(-10L);
        List<Window> windows = windowDao.findAll().stream().filter(w -> w.getRoom().equals(room)).collect(Collectors.toList());

        windowDao.deleteAllByRoom(-10L);
        assertThat(windowDao.findAll().size()).isEqualTo(4 - windows.size());

    }
}
