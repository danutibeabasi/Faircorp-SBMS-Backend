package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * RESTful API for managing rooms, windows, and heaters in a building.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    /**
     * Data access object for rooms.
     */
    private final RoomDao roomDao;

    /**
     * Data access object for windows.
     */
    private final WindowDao windowDao;

    /**
     * Data access object for heaters.
     */
    private final HeaterDao heaterDao;

    /**
     * Data access object for buildings.
     */
    private final BuildingDao buildingDao;

    /**
     * Constructs a new room controller with the given dependencies.
     *
     * @param roomDao data access object for rooms
     * @param windowDao data access object for windows
     * @param heaterDao data access object for heaters
     * @param buildingDao data access object for buildings
     */
    @Autowired
    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao, BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }

    /**
     * Retrieves a list of all rooms in the database.
     *
     * @return list of room DTOs
     */
    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

    /**

     Retrieves a single room by its ID.
     @param id ID of the room
     @return room DTO, or null if the room does not exist
     */
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    /**

     Retrieves a list of windows in a room.
     @param id ID of the room
     @return list of window DTOs, or null if the room does not exist
     */
    @GetMapping(path = "/{id}/windows")
    public List<WindowDto> findWindows(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> room.getWindows().stream().map(WindowDto::new).collect(Collectors.toList())).orElse(null);
    }

    /**

     Updates the status of all windows in a room.
     @param id ID of the room
     */
    @PutMapping(path = "/{id}/switchWindow")
    public void switchWindows(@PathVariable Long id) {
        roomDao.findById(id).map(Room::getWindows).orElse(null).stream().forEach(w -> w.setWindowStatus(w.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN));
    }

    /**

     Updates the status of all heaters in a room.
     @param id ID of the room
     */
    @PutMapping(path = "/{id}/switchHeaters")
    public void switchHeaters(@PathVariable Long id) {
        roomDao.findById(id).map(Room::getHeaters).orElse(null).stream().forEach(h -> h.setHeaterStatus(h.getHeaterStatus() ==  HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON));
    }

    /**
     * Creates or updates a room in the database.
     *
     * @param dto DTO containing the information for the room
     * @return DTO for the created or updated room
     */
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        if (dto.getId() != null) {
            room = roomDao.findById(dto.getId()).orElse(null);
        }
        if (room == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName(),dto.getCurrentTemperature(), dto.getTargetTemperature(), buildingDao.getOne(dto.getBuildingId())));
        } else {
            room.setFloor(dto.getFloor());
            room.setName(dto.getName());
            room.setCurrentTemperature(dto.getCurrentTemperature());
            room.setTargetTemperature(dto.getTargetTemperature());
            roomDao.save(room);
        }

        return new RoomDto(room);
    }

    /**
     * Deletes a room from the database, along with all of its windows and heaters.
     *
     * @param id ID of the room to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteAllByRoom(id);
        heaterDao.deleteAllByRoom(id);
        roomDao.deleteById(id);
    }


}