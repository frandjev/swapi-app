package com.exam.swapi.service.people;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.people.IPeopleService;
import com.exam.swapi.utils.ValidationUtils;
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
        ValidationUtils.requireNotEmpty(id, "id");

        PersonDetailDTO response = swapiClient.getPersonById(id);
        if (response == null || response.getResult() == null) {
            throw new NotFoundException("No se encontró una persona con ID " + id);
        }
        return response;
    }

    @Override
    public PeopleSearchResponseDTO findPersonByName(String name) {
        ValidationUtils.requireNotEmpty(name, "name");
        String validParam = ValidationUtils.sanitizeParam(name);

        PeopleSearchResponseDTO response = swapiClient.getPersonByName(validParam);
        if (response == null || response.getResult() == null || response.getResult().isEmpty()) {
            throw new NotFoundException("No se encontraron personas con nombre: " + name);
        }
        return response;
    }
}
