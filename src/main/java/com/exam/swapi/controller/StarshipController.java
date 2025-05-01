package com.exam.swapi.controller;

import com.exam.swapi.model.film.FilmPageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;
import com.exam.swapi.service.starship.IStarshipService;
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
@RequestMapping("/api/starships")
public class StarshipController {

    private final IStarshipService starshipService;

    public StarshipController(IStarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @Operation(summary = "Lista naves")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado exitoso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StarshipPageResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<StarshipPageResponseDTO> listStarships() {
        return ResponseEntity.ok(starshipService.listStarships());
    }

    @Operation(summary = "Buscar naves por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Naves encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDetailDTO.class))),
            @ApiResponse(responseCode = "404", description = "Naves no encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<StarshipDetailDTO> getStarshipById(
            @Parameter(description = "ID de Naves")
            @PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(starshipService.getStarshipById(id));
    }
}
