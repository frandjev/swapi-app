package com.exam.swapi.client;

import com.exam.swapi.config.SwapiProperties;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class SwapiClientImpl implements ISwapiClient {

    private final RestTemplate restTemplate;
    private final SwapiProperties swapiProperties;

    public SwapiClientImpl(RestTemplate restTemplate, SwapiProperties swapiProperties) {
        this.restTemplate = restTemplate;
        this.swapiProperties = swapiProperties;
    }

    // ---------- People ---------- //
    @Override
    public PeoplePageResponseDTO getPeople(int page) {
        String url = swapiProperties.getBaseUrl() + "/people?page=" + page;
        return restTemplate.getForObject(url, PeoplePageResponseDTO.class);
    }

    @Override
    public PersonDetailDTO getPersonById(String id) {
        String url = swapiProperties.getBaseUrl() + "/people/" + id;
        try {
            return restTemplate.getForObject(url, PersonDetailDTO.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("No se encontró una persona con ID " + id);
        }
    }

    @Override
    public PeopleSearchResponseDTO getPersonByName(String name) {
        String url = swapiProperties.getBaseUrl() + "/people?name=" + name;
        try {
            return restTemplate.getForObject(url, PeopleSearchResponseDTO.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("No se encontró una persona con nombre: " + name);
        }
    }

    // ---------- Films ---------- //
    @Override
    public FilmPageResponseDTO getFilms() {
        String url = swapiProperties.getBaseUrl() + "/films";
        return restTemplate.getForObject(url, FilmPageResponseDTO.class);
    }

    @Override
    public FilmDetailDTO getFilmById(String id) {
        String url = swapiProperties.getBaseUrl() + "/films/" + id;
        try {
            return restTemplate.getForObject(url, FilmDetailDTO.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException("No se encontró una película con ID " + id);
        }
    }
}