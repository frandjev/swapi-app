package com.exam.swapi.model.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiclePropertiesDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("vehicle_class")
    private String vehicleClass;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("length")
    private String length;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("pilots")
    private List<String> pilots;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;
}
