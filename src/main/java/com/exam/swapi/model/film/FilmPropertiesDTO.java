package com.exam.swapi.model.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class FilmPropertiesDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("vehicles")
    private List<String> vehicles;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("url")
    private String url;

    @JsonProperty("created")
    private String created;

    @JsonProperty("edited")
    private String edited;
}
