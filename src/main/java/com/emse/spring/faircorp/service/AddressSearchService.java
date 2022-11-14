package com.emse.spring.faircorp.service;

import com.emse.spring.faircorp.dto.ApiGouvAdressDto;
import com.emse.spring.faircorp.dto.ApiGouvFeatureDto;
import com.emse.spring.faircorp.dto.ApiGouvResponseDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressSearchService {
    private final RestTemplate restTemplate;
    public AddressSearchService(RestTemplateBuilder restTemplateBuilder) {
        //"URI is must be absolute",
        this.restTemplate = restTemplateBuilder.rootUri("https://api-adresse.data.gouv.fr").build();
        //and the test is failing with the following error:
    }

    public List<ApiGouvAdressDto> findAddress(List<String> keys) {
        String params = String.join("+", keys);
        String uri = UriComponentsBuilder.fromUriString("/search")
                .queryParam("q",params)
                .queryParam("limit", 15)
                .build()
                .toUriString();
                ApiGouvResponseDto response = restTemplate.getForObject(uri, ApiGouvResponseDto.class);
                return response.getFeatures().stream()
                        .map(ApiGouvFeatureDto::getProperties)
                        .collect(Collectors.toList());

}
}

