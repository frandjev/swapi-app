package com.exam.swapi.service.film;

import com.exam.swapi.client.ISwapiClient;
import com.exam.swapi.exception.NotFoundException;
import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.utils.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements IFilmService{
    private final ISwapiClient swapiClient;

    public FilmServiceImpl(ISwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public FilmPageResponseDTO listFilms() {

        FilmPageResponseDTO response = swapiClient.getFilms();
        if (response == null || response.getResult() == null || response.getResult().isEmpty()) {
            throw new NotFoundException("No se encontraron películas disponibles.");
        }
        return response;
    }

    @Override
    public FilmDetailDTO getFilmById(String id) {
        ValidationUtils.requireNotEmpty(id, "id");

        FilmDetailDTO response = swapiClient.getFilmById(id);
        if (response == null || response.getResult() == null) {
            throw new NotFoundException("No se encontró una película con ID " + id);
        }
        return response;
    }
}
