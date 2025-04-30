package com.exam.swapi.client;

import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;

public interface ISwapiClient {
    PeoplePageResponseDTO getPeople(int page);

    PersonDetailDTO getPersonById(String id);

    PeopleSearchResponseDTO getPersonByName(String name);

    FilmPageResponseDTO getFilms();

    FilmDetailDTO getFilmById(String id);
}
