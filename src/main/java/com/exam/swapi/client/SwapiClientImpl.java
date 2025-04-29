package com.exam.swapi.client;

import com.exam.swapi.config.SwapiProperties;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SwapiClientImpl implements ISwapiClient{

    private final RestTemplate restTemplate;
    private final SwapiProperties swapiProperties;

    public SwapiClientImpl(RestTemplate restTemplate, SwapiProperties  swapiProperties) {
        this.restTemplate = restTemplate;
        this.swapiProperties = swapiProperties;
    }

    @Override
    public PeoplePageResponseDTO getPeople(int page) {
        String url = swapiProperties.getBaseUrl() + "/people?page=" + page;
        return restTemplate.getForObject(url, PeoplePageResponseDTO.class);
    }

    @Override
    public PersonDetailDTO getPersonById(String id) {
        String url = swapiProperties.getBaseUrl() + "/people/" + id;
        return restTemplate.getForObject(url, PersonDetailDTO.class);
    }

    @Override
    public PeoplePageResponseDTO getPersonByName(String name) {
        String url = swapiProperties.getBaseUrl() + "/people?name=" + name;
        return restTemplate.getForObject(url, PeoplePageResponseDTO.class);
    }
}
