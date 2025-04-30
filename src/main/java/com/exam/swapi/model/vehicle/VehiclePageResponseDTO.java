package com.exam.swapi.model.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehiclePageResponseDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("results")
    private List<VehicleDTO> results;
}
