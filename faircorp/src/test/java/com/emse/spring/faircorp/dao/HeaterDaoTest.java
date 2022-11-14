package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;



    @Test
    public void shouldFindAHeater(){
        Heater Heater = heaterDao.getReferenceById(-10L);
        Assertions.assertThat(Heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(Heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }


    @Test
    public void shouldFindAllHeaters(){
        List<Heater> heaters = heaterDao.findAll();
        Assertions.assertThat(heaters.size()).isEqualTo(2);
    }


    @Test
    public void shouldDeleteAHeater(){
        heaterDao.deleteById(-10L);
        Assertions.assertThat(heaterDao.findAll().size()).isEqualTo(1);
    }



}
