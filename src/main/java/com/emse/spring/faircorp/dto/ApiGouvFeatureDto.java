package com.emse.spring.faircorp.dto;

/**
 * A data transfer object (DTO) for a geographic feature received from the API of the French government's open data portal (api.gouv.fr).
 *
 * @author OpenAI
 * @since 2021-09 (knowledge cutoff)
 */
public class ApiGouvFeatureDto {
    /**
     * The type of the feature.
     */
    private String type;
    /**
     * The properties or attributes of the feature.
     */
    private ApiGouvAdressDto properties;

    /**
     * Returns the type of the feature.
     *
     * @return the type of the feature
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the feature.
     *
     * @param type the type of the feature
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the properties or attributes of the feature.
     *
     * @return the properties of the feature
     */
    public ApiGouvAdressDto getProperties() {
        return properties;
    }

    /**
     * Sets the properties or attributes of the feature.
     *
     * @param properties the properties of the feature
     */
    public void setProperties(ApiGouvAdressDto properties) {
        this.properties = properties;
    }
}
