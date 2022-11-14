package com.emse.spring.faircorp.api;

import com.emse.spring.faircorp.dto.ApiGouvAdressDto;
import com.emse.spring.faircorp.service.AddressSearchService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@CrossOrigin
@RestController // (1)
@RequestMapping("/api/address") // (2)
@Transactional
public class AddressController {
    private final AddressSearchService address;
    public AddressController(AddressSearchService address) {
        this.address = address;
    }

    @GetMapping
    public List<ApiGouvAdressDto> findAddress(@RequestParam List<String> keys){
        return address.findAddress(keys);
    }
}

