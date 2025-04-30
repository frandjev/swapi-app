package com.exam.swapi.service.film;

import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;

public interface IFilmService {
    FilmPageResponseDTO listFilms();

    FilmDetailDTO getFilmById(String id);
}
