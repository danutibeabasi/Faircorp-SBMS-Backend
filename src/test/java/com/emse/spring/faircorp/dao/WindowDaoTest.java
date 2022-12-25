package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getReferenceById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.OPEN);
    }

    @Test
    public void shouldFindAllWindows() {
        Window window = windowDao.getReferenceById(-10L);
        Assertions.assertThat(windowDao.findAll().size()).isEqualTo(4);
    }

    @Test
    public void shouldDeleteWindowsRoom() {

        Room room = roomDao.getReferenceById(-10L);
        List<Window> windows = windowDao.findAll().stream().filter(w -> w.getRoom().equals(room)).collect(Collectors.toList());

        windowDao.deleteAllByRoom(-10L);
        Assertions.assertThat(windowDao.findAll().size()).isEqualTo(4 - windows.size());

    }
}