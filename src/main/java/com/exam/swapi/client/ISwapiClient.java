package com.exam.swapi.client;

import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;
import com.exam.swapi.model.vehicle.VehicleDetailDTO;
import com.exam.swapi.model.vehicle.VehiclePageResponseDTO;

public interface ISwapiClient {
    PeoplePageResponseDTO getPeople(int page);

    PersonDetailDTO getPersonById(String id);

    PeopleSearchResponseDTO getPersonByName(String name);

    FilmPageResponseDTO getFilms();

    FilmDetailDTO getFilmById(String id);

    StarshipPageResponseDTO getStarships();

    StarshipDetailDTO getStarshipById(String id);

    VehiclePageResponseDTO getVehicles();

    VehicleDetailDTO getVehicleById(String id);
}
