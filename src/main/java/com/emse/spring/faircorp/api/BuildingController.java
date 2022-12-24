package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * RestController for managing buildings, rooms, heaters, and windows.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/buildings")
@Transactional
public class BuildingController {
    @Autowired
    private final WindowDao windowDao;
    @Autowired
    private final HeaterDao heaterDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private BuildingDao buildingDao;

    /**
     * Constructor for BuildingController.
     *
     * @param windowDao the WindowDao to use for managing windows
     * @param heaterDao the HeaterDao to use for managing heaters
     * @param roomDao the RoomDao to use for managing rooms
     * @param buildingDao the BuildingDao to use for managing buildings
     */
    public BuildingController(WindowDao windowDao, HeaterDao heaterDao, RoomDao roomDao, BuildingDao buildingDao) {
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    /**
     * Returns a list of all buildings.
     *
     * @return a list of BuildingDto objects representing all buildings
     */
    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    /**
     * Returns a specific building based on its ID.
     *
     * @param id the ID of the building to retrieve
     * @return a BuildingDto object representing the requested building, or null if the building was not found
     */
    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> new BuildingDto(building)).orElse(null);
    }

    /**
     * Returns a list of all rooms in a specific building.
     *
     * @param id the ID of the building to retrieve rooms for
     * @return a list of RoomDto objects representing the rooms in the requested building, or null if the building was not found
     */
    @GetMapping(path = "/{id}/rooms")
    public List<RoomDto> findRooms(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> building.getRooms().stream().map(RoomDto::new)
                .collect(Collectors.toList())).orElse(null);
    }

    /**
     * Updates the status of all heaters in all rooms of a specific building.
     *
     * @param id the ID of the building to update heaters for
     * @return a list of updated Heater objects
     */
    @PutMapping(path = "/{id}/switchHeaters")
    public List<Heater> switchHeaters(@PathVariable Long id) {
        List<Heater> totalHeaters = new LinkedList<>();
        List<Room> roomList = roomDao.findByBuildingId(id);
        for (Room room : roomList) {
            Optional<Heater> heaterList = heaterDao.findById(room.getId());
            if (heaterList.isPresent()) {
                Heater heater = heaterList.get();
                heater.setHeaterStatus(heater.getHeaterStatus() ==  HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
                totalHeaters.add(heater);
            }
        }
        return totalHeaters;
    }

    /**
     * Updates the status of all windows in all rooms of a specific building.
     *
     * @param id the ID of the building to update windows for
     * @return a list of updated Window objects
     */
    @PutMapping(path = "/{id}/switchWindows")
    public List<Window> switchWindows(@PathVariable Long id) {
        List<Window> totalWindows = new LinkedList<>();
        List<Room> roomList = roomDao.findByBuildingId(id);
        for (Room room : roomList) {
            Optional<Window> windowsList = windowDao.findById(room.getId());
            if (windowsList.isPresent()) {
                Window window = windowsList.get();
                window.setWindowStatus(window.getWindowStatus() ==  WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
                totalWindows.add(window);
            }
        }
        return totalWindows;
    }

    /**
     * Creates a new building or updates an existing building's name.
     *
     * @param dto DTO containing building information, including ID and name
     * @return DTO containing the created or updated building's information
     */
    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() != null) {
            building = buildingDao.findById(dto.getId()).orElse(null);
        }
        if (building == null) {
            building = buildingDao.save(new Building(dto.getName()));
        } else {
            building.setName(dto.getName());
            buildingDao.save(building);
        }
        return new BuildingDto(building);
    }

    /**
     * Deletes a building and all associated rooms, windows, and heaters.
     *
     * @param id ID of the building to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        List<Room> roomList =  roomDao.findByBuildingId(id);
        for (Room room : roomList) {
            Optional<Window> windowList = windowDao.findById(room.getId());
            if (windowList.isPresent()) {
                Window window = windowList.get();
                windowDao.delete(window);
            }
            Optional<Heater> heaterList = heaterDao.findById(room.getId());
            if (heaterList.isPresent()) {
                Heater heater = heaterList.get();
                heaterDao.delete(heater);
            }
            roomDao.delete(room);
        }
        buildingDao.deleteById(id);
    }


}

