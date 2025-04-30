package com.exam.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmPageResponseDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<FilmDetailDTO.FilmResultDTO> result;
}
