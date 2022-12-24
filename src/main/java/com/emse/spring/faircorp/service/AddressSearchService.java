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

/**
 * A service class for searching for addresses using the French government's API
 * (https://adresse.data.gouv.fr/api/).
 *
 * This class uses the Spring RestTemplate to make HTTP requests to the API and
 * retrieve data in the form of DTOs (data transfer objects). It also uses the
 * UriComponentsBuilder to construct the API URLs with the appropriate query
 * parameters.
 */
@Service
public class AddressSearchService {

    private final RestTemplate restTemplate;

    /**
     * Constructs a new AddressSearchService using the given RestTemplateBuilder.
     *
     * @param restTemplateBuilder a builder for creating the RestTemplate used to
     *                            make HTTP requests to the API.
     */
    public AddressSearchService(RestTemplateBuilder restTemplateBuilder) {
        // Set the root URI of the API as the base URL for the RestTemplate
        this.restTemplate = restTemplateBuilder.rootUri("https://api-adresse.data.gouv.fr").build();
    }

    /**
     * Searches for addresses using the given search keys and returns a list of
     * matching addresses.
     *
     * This method constructs a URL using the UriComponentsBuilder and makes an
     * HTTP GET request to the API using the RestTemplate. It then processes the
     * response and returns a list of addresses in the form of ApiGouvAdressDto
     * objects.
     *
     * @param keys a list of search keys to use when searching for addresses.
     * @return a list of matching addresses.
     */
    public List<ApiGouvAdressDto> findAddress(List<String> keys) {
        // Join the search keys into a single string with "+" characters between them
        String params = String.join("+", keys);

        // Construct the API URL with the search keys and other query parameters
        String uri = UriComponentsBuilder.fromUriString("/search")
                .queryParam("q", params)
                .queryParam("limit", 15)
                .build()
                .toUriString();

        // Make the HTTP GET request to the API and retrieve the response
        ApiGouvResponseDto response = restTemplate.getForObject(uri, ApiGouvResponseDto.class);

        // Extract the addresses from the response and return them as a list
        return response.getFeatures().stream()
                        .map(ApiGouvFeatureDto::getProperties)
                        .collect(Collectors.toList());

}
}

