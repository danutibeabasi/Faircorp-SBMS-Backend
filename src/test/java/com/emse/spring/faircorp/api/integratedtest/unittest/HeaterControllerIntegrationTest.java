package com.emse.spring.faircorp.api.integratedtest.unittest;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.http.MediaType.APPLICATION_JSON;
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
        // Set up test data in the database
        Room room = createRoom("room 1");
        roomDao.save(room);
        Heater heater1 = createHeater("heater 1", room);
        Heater heater2 = createHeater("heater 2", room);
        heaterDao.save(heater1);
        heaterDao.save(heater2);

        String username = "admin";
        String password = "password";

        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
        String authHeader = "Basic " + new String(encodedAuth);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/heaters")
                        .header("Authorization", authHeader)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("heater 1", "heater 2")))
                .andReturn();

        // Assert that the returned list of names contains the expected values
        ObjectMapper mapper = new ObjectMapper();
        List<String> names = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<String>>() {});
        assertThat(names, containsInAnyOrder("heater 1", "heater 2"));

    }


    private Heater createHeater(String name, Room room) {
        Heater heater = new Heater();
        heater.setName(name);
        heater.setRoom(room);
        // Set any other required properties here
        return heater;
    }

    private Room createRoom(String name) {
        Room room = new Room();
        room.setName(name);
        // Set any other required properties here
        return room;
    }
}
