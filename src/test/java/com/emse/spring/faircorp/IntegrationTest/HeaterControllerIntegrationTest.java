package com.emse.spring.faircorp.IntegrationTest;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Base64Utils;

import javax.transaction.Transactional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional

class HeaterControllerIntegrationTest {

    @MockBean
    private HeaterDao heaterDao;

    @MockBean
    private RoomDao roomDao;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldLoadHeaters() throws Exception {
        Room room = new Room("Room 1", 10, 10, 10);
        roomDao.save(room);
        Heater heater = new Heater("Heater 1", 10, room);
        heaterDao.save(heater);
        Heater heater2 = new Heater("Heater 2", 10, room);
        heaterDao.save(heater2);
        String username = "admin";
        String password = "password";
        String authHeaderValue = "Basic " + Base64Utils.encodeToString((username + ":" + password).getBytes());

        mockMvc.perform(get("/api/heaters")
                        .header("Authorization", authHeaderValue))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Heater 1")))
                .andExpect((ResultMatcher) jsonPath("$[1].name", is("Heater 2")));

    }

    @Test
    void shouldLoadHeater() throws Exception {
        Room room = new Room("Room 1", 10, 10, 10);
        roomDao.save(room);
        Heater heater = new Heater("Heater 1", 10, room);
        heaterDao.save(heater);
        Heater heater2 = new Heater("Heater 2", 10, room);
        heaterDao.save(heater2);
        String username = "admin";
        String password = "password";
        String authHeaderValue = "Basic " + Base64Utils.encodeToString((username + ":" + password).getBytes());

        mockMvc.perform(get("/api/heaters/{id}", heater.getId())
                        .header("Authorization", authHeaderValue))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$.name", is("Heater 1")));

}

    }
