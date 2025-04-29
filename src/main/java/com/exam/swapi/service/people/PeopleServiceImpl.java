package com.exam.swapi.service.people;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.people.IPeopleService;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements IPeopleService {

    private final ISwapiClient swapiClient;

    public PeopleServiceImpl(ISwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public PeoplePageResponseDTO listPeople(int page) {
        return swapiClient.getPeople(page);
    }

    @Override
    public PersonDetailDTO findPersonById(String id) {
        return swapiClient.getPersonById(id);
    }

    @Override
    public PeoplePageResponseDTO findPersonByName(String name) {
        return swapiClient.getPersonByName(name);
    }
}
