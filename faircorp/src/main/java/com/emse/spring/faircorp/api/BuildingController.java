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



    public BuildingController(WindowDao windowDao, HeaterDao heaterDao, RoomDao roomDao, BuildingDao buildingDao) {
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
        this.buildingDao = buildingDao;
    }

    @GetMapping
    public List<BuildingDto> findAll() {
        return buildingDao.findAll()
                .stream()
                .map(BuildingDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> new BuildingDto(building)).orElse(null);
    }

    @GetMapping(path = "/{id}/rooms")
    public List<RoomDto> findRooms(@PathVariable Long id) {
        return buildingDao.findById(id).map(building -> building.getRooms().stream().map(RoomDto::new).collect(Collectors.toList())).orElse(null);
    }

    @PutMapping(path = "/{id}/switchHeaters")
    public List<Heater>  switchHeaters(@PathVariable Long id) {
        List<Heater> TotalHeaters = new LinkedList<Heater>();;
        List<Room> roomList =  roomDao.findByBuildingId(id);
        for (Room room : roomList) {
            Optional<Heater> heaterList = heaterDao.findById(room.getId());
            if (heaterList.isPresent()) {
                Heater heater = heaterList.get();
                heater.setHeaterStatus(heater.getHeaterStatus() ==  HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
                TotalHeaters.add(heater);
            }
        }
        return TotalHeaters;
    }

    @PutMapping(path = "/{id}/switchWindows")
    public List<Window>  switchWindows(@PathVariable Long id) {
        List<Window> TotalWindows = new LinkedList<Window>();;
        List<Room> roomList =  roomDao.findByBuildingId(id);
        for (Room room : roomList) {
            Optional<Window> windowsList = windowDao.findById(room.getId());
            if (windowsList.isPresent()) {
                Window window = windowsList.get();
                window.setWindowStatus(window.getWindowStatus() ==  WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN);
            }
        }
        return TotalWindows;
    }

    @PostMapping
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        if (dto.getId() != null) {
            building = buildingDao.findById(dto.getId()).orElse(null);
        }
        if (building == null) {
            building = buildingDao.save(new Building(dto.getName() ));
        } else {
            building.setName(dto.getName());
            buildingDao.save(building);
        }

        return new BuildingDto(building);
    }


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

