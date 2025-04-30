package com.exam.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDetailDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private FilmResultDTO result;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FilmResultDTO {

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("description")
        private String description;

        @JsonProperty("properties")
        private FilmPropertiesDTO properties;
    }
}
