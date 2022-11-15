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

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {


    @Autowired
    private final RoomDao roomDao;

    @Autowired
    private final WindowDao windowDao;

    @Autowired
    private final HeaterDao heaterDao;

    @Autowired
    private final BuildingDao buildingDao;




    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao, BuildingDao buildingDao) { // (4)
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }

    //get all rooms
    @GetMapping // (5)
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

     //get a room by id
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // (7)
    }

    //get all windows in a room
    @GetMapping(path = "/{id}/windows")
    public List<WindowDto> findWindows(@PathVariable Long id) {
        return roomDao.findById(id).map(room -> room.getWindows().stream().map(WindowDto::new).collect(Collectors.toList())).orElse(null);
    }

    //Update the status of a window
    @PutMapping(path = "/{id}/switchWindow")
    public void switchWindows(@PathVariable Long id) {
        roomDao.findById(id).map(Room::getWindows).orElse(null).stream().forEach(w -> w.setWindowStatus(w.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED : WindowStatus.OPEN));
    }

    //Update HeaterStatus of a heater in a room
    @PutMapping(path = "/{id}/switchHeaters")
    public void switchHeaters(@PathVariable Long id) {
        roomDao.findById(id).map(Room::getHeaters).orElse(null).stream().forEach(h -> h.setHeaterStatus(h.getHeaterStatus() ==  HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON));
    }

    //Create a room
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

    //Delete a room by id and all its windows and heaters
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteAllByRoom(id);
        heaterDao.deleteAllByRoom(id);
        roomDao.deleteById(id);
    }


}