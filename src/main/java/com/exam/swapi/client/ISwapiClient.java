package com.exam.swapi.client;

public interface ISwapiClient {
    String getPeople(int page);

    String getPersonById(String id);

    String getPersonByName(String name);
}
