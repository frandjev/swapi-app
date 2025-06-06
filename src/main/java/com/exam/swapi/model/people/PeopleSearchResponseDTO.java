package com.exam.swapi.model.people;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleSearchResponseDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private List<PersonDetailDTO.PersonResultDTO> result;
}
