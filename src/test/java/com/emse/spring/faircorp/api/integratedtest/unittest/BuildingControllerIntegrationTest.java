package com.emse.spring.faircorp.api.integratedtest.unittest;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.model.Building;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BuildingControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BuildingDao buildingDao;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    void shouldDeleteBuilding() throws Exception {
        Building building = new Building("Building 1");
        buildingDao.save(building);
        Long newBuildingId = building.getId();

        mockMvc.perform(delete("/api/buildings/"+newBuildingId.toString()))
                .andExpect(status().isOk());

        Optional<Building> deletedBuilding = buildingDao.findById(newBuildingId);
        Assertions.assertThat(deletedBuilding.isEmpty()).isTrue();
    }
}

