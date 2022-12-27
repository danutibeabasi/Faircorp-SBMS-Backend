package com.emse.spring.faircorp.api.integratedtest.unittest;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WindowControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

    @Test
    void shouldLoadWindows() throws Exception {
        // Set up test data
        Window window1 = createWindow("window 1");
        Window window2 = createWindow("window 2");
        windowDao.save(window1);
        windowDao.save(window2);

        String username = "admin";
        String password = "password";

        // Send HTTP request and receive response
        ResponseEntity<String> response = restTemplate.withBasicAuth(username, password)
                .getForEntity("/api/windows", String.class);

        // Verify response status and content
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());
        assertThat(root.isArray()).isTrue();
        assertThat(root).hasSize(2);
        assertThat(root.get(0).get("name").asText()).isEqualTo("window 1");
        assertThat(root.get(1).get("name").asText()).isEqualTo("window 2");
    }

    private Window createWindow(String name) {
        Window window = new Window();
        window.setName(name);
        window.setWindowStatus(WindowStatus.OPEN);
        return window;
    }
}

