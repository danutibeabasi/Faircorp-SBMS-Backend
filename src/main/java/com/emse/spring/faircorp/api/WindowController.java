package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    /**
     * Constructs a new WindowController with the given WindowDao and RoomDao.
     *
     * @param windowDao the WindowDao to use for database operations
     * @param roomDao the RoomDao to use for database operations
     */
    public WindowController(WindowDao windowDao, RoomDao roomDao) { // (4)
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    /**
     * Handles a GET request to retrieve all windows from the database.
     *
     * @return a list of WindowDto objects representing all windows in the database
     */
    @GetMapping // (5)
    public List<WindowDto> findAll() {
        return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());  // (6)
    }

    /**
     * Handles a GET request to retrieve a single window from the database by ID.
     *
     * @param id the ID of the window to retrieve
     * @return a WindowDto object representing the retrieved window, or null if no such window exists
     */
    @GetMapping(path = "/{id}")
    public WindowDto findById(@PathVariable Long id) {
        return windowDao.findById(id).map(WindowDto::new).orElse(null); // (7)
    }

    /**
     * Handles a PUT request to update the status of a single window in the database.
     *
     * @param id the ID of the window to update
     * @return a WindowDto object representing the updated window
     * @throws IllegalArgumentException if no window with the given ID exists
     */
    @PutMapping(path = "/{id}/switch")
    public WindowDto switchStatus(@PathVariable Long id) {
        Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
        return new WindowDto(window);
    }

    /**
     * Handles a POST request to create a new window in the database.
     *
     * @param dto a WindowDto object containing the data for the new window
     * @return a WindowDto object representing the created window
     */
    @PostMapping // (8)
    public WindowDto create(@RequestBody WindowDto dto) {
        // WindowDto must always contain the window room
        Room room = roomDao.getReferenceById(dto.getRoomId());
        Window window = null;
        // On creation id is not defined
        if (dto.getId() != null) {
            window = windowDao.findById(dto.getId()).orElse(null);
        }
        if (dto.getId() == null) {
            window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
        }
        else {
            window = windowDao.getReferenceById(dto.getId());  // (9)
            window.setWindowStatus(dto.getWindowStatus());
        }
        return new WindowDto(window);
    }

    /**
     * Handles a DELETE request to delete a single window from the database.
     *
     * @param id the ID of the window to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}