package com.exam.swapi.service.people;

import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;

public interface IPeopleService {
    PeoplePageResponseDTO listPeople(int page);
    PersonDetailDTO findPersonById(String id);
    PeopleSearchResponseDTO findPersonByName(String name);

}
