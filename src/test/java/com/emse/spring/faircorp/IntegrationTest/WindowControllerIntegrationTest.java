package com.emse.spring.faircorp.IntegrationTest;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class WindowControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WindowDao windowDao;

    @Autowired
    private RoomDao roomDao;

//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void testLoadWindows() throws Exception {
//        // Create two windows in the database
//        Window window1 = createWindow("window 1");
//        windowDao.save(window1);
//        Window window2 = createWindow("window 2");
//        windowDao.save(window2);
//
//        // Send an HTTP GET request to the /api/windows endpoint
//        mockMvc.perform(get("/api/windows").accept(APPLICATION_JSON))
//                // Verify that the response has a 200 OK status
//                .andExpect(status().isOk())
//                // Verify that the response body contains the names of the two windows
//                .andExpect((ResultMatcher) jsonPath("[*].name").value(containsInAnyOrder("window 1", "window 2")));
//    }
//
//    @Test
//    @WithMockUser(username = "admin", roles = "ADMIN")
//    void testDeleteWindow() throws Exception {
//        // Create a window in the database
//        Window window = createWindow("window 1");
//        windowDao.save(window);
//
//        // Send an HTTP DELETE request to the /api/windows/{id} endpoint
//        mockMvc.perform(delete("/api/windows/{id}", window.getId()).accept(APPLICATION_JSON))
//                // Verify that the response has a 200 OK status
//                .andExpect(status().isOk())
//                // Verify that the window has been deleted
//                .andExpect((ResultMatcher) content().string(""));
//
//        // Verify that the window has been deleted from the database
//        Optional<Window> deletedWindow = windowDao.findById(window.getId());
//        assertFalse(deletedWindow.isPresent());
//    }
//
//
//
//    private Window createWindow(String name) {
//        Window window = new Window();
//        window.setName(name);
//        window.setWindowStatus(WindowStatus.OPEN);
//        window.setRoom(createRoom("room 1"));
//        return window;
//    }
//
//    private Room createRoom(String name) {
//        Room room = new Room();
//        room.setName(name);
//        return room;
//    }


}
