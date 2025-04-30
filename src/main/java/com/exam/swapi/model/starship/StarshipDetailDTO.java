package com.exam.swapi.model.starship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StarshipDetailDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private StarshipResultDTO result;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StarshipResultDTO {

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("description")
        private String description;

        @JsonProperty("properties")
        private StarshipPropertiesDTO properties;
    }
}
