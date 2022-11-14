package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;

    @Test
    public void shouldFindAWindow(){
        Window Window = windowDao.getReferenceById(-10L);
        Assertions.assertThat(Window.getName()).isEqualTo("Window1");
        Assertions.assertThat(Window.getRoom_window().getName()).isEqualTo("Room1");
    }



}
