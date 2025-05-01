package com.exam.swapi.controller;

import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.people.IPeopleService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/people")
public class PeopleController {

    private final IPeopleService peopleService;

    public PeopleController(IPeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Operation(summary = "Lista personas paginadas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado exitoso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeoplePageResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<PeoplePageResponseDTO> listPeople(
            @Parameter(description = "Número de página a recuperar", example = "1")
            @RequestParam(defaultValue = "1") int page) {
        ValidationUtils.requirePositive(page, "page");
        return ResponseEntity.ok(peopleService.listPeople(page));
    }

    @Operation(summary = "Buscar persona por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonDetailDTO.class))),
            @ApiResponse(responseCode = "404", description = "Persona no encontrada",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonDetailDTO> getPersonById(
            @Parameter(description = "ID de la persona", example = "1")
            @PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(peopleService.findPersonById(id));
    }

    @Operation(summary = "Buscar personas por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Búsqueda exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PeopleSearchResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Personas no encontradas",
                    content = @Content)
    })
    @GetMapping("/search")
    public ResponseEntity<PeopleSearchResponseDTO> getPeopleByName(
            @Parameter(description = "Nombre a buscar", example = "Luke Skywalker")
            @RequestParam String name) {
        ValidationUtils.requireNotEmpty(name, "name");
        return ResponseEntity.ok(peopleService.findPersonByName(name));
    }
}
