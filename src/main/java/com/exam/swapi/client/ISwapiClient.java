package com.exam.swapi.client;

import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;

public interface ISwapiClient {
    PeoplePageResponseDTO getPeople(int page);

    PersonDetailDTO getPersonById(String id);

    PeoplePageResponseDTO getPersonByName(String name);
}
