package com.exam.swapi.model.starship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipPageResponseDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("results")
    private List<StarshipDTO> results;
}
