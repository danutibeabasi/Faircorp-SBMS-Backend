package com.emse.spring.faircorp.dto;

/**
 * A data transfer object (DTO) for an address received from the API of the French government's open data portal (api.gouv.fr).
 *
 * @author OpenAI
 * @since 2021-09 (knowledge cutoff)
 */
public class ApiGouvAdressDto {
    /**
     * The unique identifier of the address.
     */
    private String id;
    /**
     * The label or name of the address.
     */
    private String label;
    /**
     * The house number of the address.
     */
    private String housenumber;
    /**
     * The score or relevance of the address.
     */
    private Double score;
    /**
     * The postal code of the address.
     */
    private String postcode;
    /**
     * The city code of the address.
     */
    private String citycode;
    /**
     * The city of the address.
     */
    private String city;
    /**
     * The context or environment of the address.
     */
    private String context;
    /**
     * The type or category of the address.
     */
    private String type;
    /**
     * The x-coordinate of the address.
     */
    private Double x;
    /**
     * The y-coordinate of the address.
     */
    private Double y;

    /**
     * Returns the unique identifier of the address.
     *
     * @return the id of the address
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the address.
     *
     * @param id the id of the address
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the label or name of the address.
     *
     * @return the label of the address
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label or name of the address.
     *
     * @param label the label of the address
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Returns the house number of the address.
     *
     * @return the house number of the address
     */
    public String getHousenumber() {
        return housenumber;
    }

    /**
     * Sets the house number of the address.
     *
     * @param housenumber the house number of the address
     */
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    /**
     * Returns the score or relevance of the address.
     *
     * @return the score of the address
     */
    public Double getScore() {
        return score;
    }

    /**
     * Sets the score or relevance of the address.
     *
     * @param score the score of the address
     */
    public void setScore(Double score) {
        this.score = score;
    }/**
     * Returns the postal code of the address.
     *
     * @return the postal code of the address
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the postal code of the address.
     *
     * @param postcode the postal code of the address
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * Returns the city code of the address.
     *
     * @return the city code of the address
     */
    public String getCitycode() {
        return citycode;
    }

    /**
     * Sets the city code of the address.
     *
     * @param citycode the city code of the address
     */
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    /**
     * Returns the city of the address.
     *
     * @return the city of the address
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city the city of the address
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the context or environment of the address.
     *
     * @return the context of the address
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the context or environment of the address.
     *
     * @param context the context of the address
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * Returns the type or category of the address.
     *
     * @return the type of the address
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type or category of the address.
     *
     * @param type the type of the address
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the x-coordinate of the address.
     *
     * @return the x-coordinate of the address
     */
    public Double getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the address.
     *
     * @param x the x-coordinate of the address
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of the address.
     *
     * @return the y-coordinate of the address
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the address.
     *
     * @param y the y-coordinate of the address
     */
    public void setY(Double y) {
        this.y = y;
    }
}