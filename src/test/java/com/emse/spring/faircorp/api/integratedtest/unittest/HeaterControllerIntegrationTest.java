//package com.emse.spring.faircorp.api.integratedtest.unittest;
//
//import com.emse.spring.faircorp.dao.HeaterDao;
//import com.emse.spring.faircorp.dao.RoomDao;
//import com.emse.spring.faircorp.dto.HeaterDto;
//import com.emse.spring.faircorp.model.Heater;
//import com.emse.spring.faircorp.model.HeaterStatus;
//import com.emse.spring.faircorp.model.Room;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import javax.transaction.Transactional;
//
//import static org.hamcrest.Matchers.containsInAnyOrder;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@Transactional
//class HeaterControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private HeaterDao heaterDao;
//
//    @Autowired
//    private RoomDao roomDao;
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void shouldLoadHeaters() throws Exception {
//        // Set up test data in the database
//        Heater heater1 = createHeater("heater 1");
//        Heater heater2 = createHeater("heater 2");
//        heaterDao.save(heater1);
//        heaterDao.save(heater2);
//
//        // Send a GET request to the API endpoint to retrieve all heaters
//        mockMvc.perform(get("/api/heaters").accept(APPLICATION_JSON))
//                // Check the HTTP response status
//                .andExpect(status().isOk())
//                // Check the content of the response using JSON path
//                .andExpect((ResultMatcher) jsonPath("[*].name").value(containsInAnyOrder("heater 1", "heater 2")));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void shouldLoadAHeater() throws Exception {
//        // Set up test data in the database
//        Heater heater = createHeater("heater 1");
//        heaterDao.save(heater);
//
//        // Send a GET request to the API endpoint to retrieve a specific heater
//        mockMvc.perform(get("/api/heaters/{id}", heater.getId()).accept(APPLICATION_JSON))
//                // Check the HTTP response status
//                .andExpect(status().isOk())
//                // Check the content of the response using JSON path
//                .andExpect((ResultMatcher) jsonPath("$.name").value("heater 1"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void shouldSwitchHeater() throws Exception {
//        // Set up test data in the database
//        Heater heater = createHeater("heater 1");
//        heaterDao.save(heater);
//        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
//
//        // Create a HeaterDto object with the new status of the heater
//        HeaterDto heaterDto =
//                new HeaterDto(heater.getId(), heater.getName(), HeaterStatus.OFF, heater.getPower(), heater.getRoom().getId());
//
//        // Send a PUT request to the API endpoint to update the heater
//        mockMvc.perform(put("/api/heaters/{id}", heater.getId())
//                        .contentType(APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(heaterDto)))
//                // Check the HTTP response status
//                .andExpect(status().isOk())
//                // Check the content of the response using JSON path
//                .andExpect((ResultMatcher) jsonPath("$.name").value("heater 2"));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void shouldDeleteAHeater() throws Exception {
//        // Set up test data in the database
//        Heater heater = createHeater("heater 1");
//        heaterDao.save(heater);
//
//        // Send a DELETE request to the API endpoint to delete the heater
//        mockMvc.perform(delete("/api/heaters/{id}", heater.getId()))
//                // Check the HTTP response status
//                .andExpect(status().isOk());
//
//        // Check that the heater was deleted from the database
//        Assertions.assertThat(heaterDao.findById(heater.getId())).isEmpty();
//    }
//
//    private Heater createHeater(String name) {
//        Room room = new Room(name + " room", 1);
//        Long power = 1000L;
//        return new Heater(name, room, HeaterStatus.ON, power);
//    }
//
//}
//
