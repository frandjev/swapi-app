package com.exam.swapi.controller;

import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.service.film.IFilmService;
import com.exam.swapi.utils.ValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final IFilmService filmService;

    public FilmController(IFilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<FilmPageResponseDTO> listFilms() {
        FilmPageResponseDTO response = filmService.listFilms();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDetailDTO> getFilmById(@PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(filmService.getFilmById(id));
    }
}
