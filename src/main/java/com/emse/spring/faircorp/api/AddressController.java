package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dto.ApiGouvAdressDto;
import com.emse.spring.faircorp.service.AddressSearchService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

/**
 * RestController for searching addresses.
 */
@CrossOrigin
@RestController
@RequestMapping("/api/address")
@Transactional
public class AddressController {
    private final AddressSearchService address;

    /**
     * Constructor for AddressController.
     *
     * @param address the AddressSearchService to use for searching addresses
     */
    public AddressController(AddressSearchService address) {
        this.address = address;
    }

    /**
     * Searches for addresses matching the given keys.
     *
     * @param keys the keys to search for
     * @return a list of matching addresses
     */
    @GetMapping
    public List<ApiGouvAdressDto> findAddress(@RequestParam List<String> keys) {
        return address.findAddress(keys);
    }
}
