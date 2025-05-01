package com.exam.swapi.controller;

import com.exam.swapi.model.film.FilmDetailDTO;
import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.film.IFilmService;
import com.exam.swapi.utils.ValidationUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Lista las películas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado exitoso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FilmPageResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<FilmPageResponseDTO> listFilms() {
        return ResponseEntity.ok(filmService.listFilms());
    }

    @Operation(summary = "Buscar Peliculas por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pelicula encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDetailDTO.class))),
            @ApiResponse(responseCode = "404", description = "Pelicula no encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<FilmDetailDTO> getFilmById(
            @Parameter(description = "ID de película")
            @PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(filmService.getFilmById(id));
    }
}
