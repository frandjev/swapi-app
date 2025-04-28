package com.exam.swapi.client;

import com.exam.swapi.config.SwapiProperties;
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
    public String getPeople(int page) {
        String url = swapiProperties.getBaseUrl() + "/people?page=" + page;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String getPersonById(String id) {
        String url = swapiProperties.getBaseUrl() + "/people/" + id;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public String getPersonByName(String name) {
        String url = swapiProperties.getBaseUrl() + "/people?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }
}
