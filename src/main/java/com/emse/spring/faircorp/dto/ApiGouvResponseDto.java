package com.emse.spring.faircorp.dto;

import java.util.List;

/**
 * A data transfer object (DTO) for a response received from the API of the French government's open data portal (api.gouv.fr).
 *
 * @author OpenAI
 * @since 2021-09 (knowledge cutoff)
 */
public class ApiGouvResponseDto {
    /**
     * The version of the response.
     */
    private String version;
    /**
     * The geographic features included in the response.
     */
    private List<ApiGouvFeatureDto> features;

    /**
     * Returns the version of the response.
     *
     * @return the version of the response
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version of the response.
     *
     * @param version the version of the response
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Returns the geographic features included in the response.
     *
     * @return the list of features in the response
     */
    public List<ApiGouvFeatureDto> getFeatures() {
        return features;
    }

    /**
     * Sets the geographic features included in the response.
     *
     * @param features the list of features in the response
     */
    public void setFeatures(List<ApiGouvFeatureDto> features) {
        this.features = features;
    }
}
