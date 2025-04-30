package com.exam.swapi.model.people;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeoplePageResponseDTO {

    @JsonProperty("message")
    private String message;

    @JsonProperty("total_records")
    private int totalRecords;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("previous")
    private String previousPage;

    @JsonProperty("next")
    private String nextPage;

    @JsonProperty("results")
    private List<PersonDTO> results;
}
