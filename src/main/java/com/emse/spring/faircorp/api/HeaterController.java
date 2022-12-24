package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


/**
 * RESTful API for managing heaters in rooms
 */
@CrossOrigin
@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {

    /**
     * Data access object for heaters
     */
    private final HeaterDao heaterDao;

    /**
     * Data access object for rooms
     */
    private final RoomDao roomDao;

    /**
     * Constructor for HeaterController
     *
     * @param heaterDao data access object for heaters
     * @param roomDao data access object for rooms
     */
    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    /**
     * Retrieves a list of all heaters.
     *
     * @return list of heaters as DTOs
     */
    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    /**
     * Retrieves a specific heater by its ID.
     *
     * @param id ID of the heater to retrieve
     * @return heater as a DTO, or null if not found
     */
    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }

    /**
     * Toggles the status of a heater.
     *
     * @param id ID of the heater to toggle
     * @return updated heater as a DTO
     * @throws IllegalArgumentException if heater with given ID does not exist
     */
    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF : HeaterStatus.ON);
        return new HeaterDto(heater);
    }

    /**
     * Creates a new heater in a room or updates an existing heater's status and power.
     *
     * @param dto DTO containing heater information, including ID, name, room ID, status, and power
     * @return created or updated heater as a DTO
     */
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the heater room
        Room room = roomDao.getReferenceById(dto.getRoom_Id());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() != null) {
            heater = heaterDao.findById(dto.getId()).orElse(null);
        }

        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater( dto.getName(), room, dto.getHeaterStatus(),dto.getPower()));
        }
        else {
            heater = heaterDao.getReferenceById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setPower(dto.getPower());
        }
        return new HeaterDto(heater);
    }

    /**
     * Deletes a heater by its ID.
     *
     * @param id ID of the heater to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
