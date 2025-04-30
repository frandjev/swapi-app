package com.exam.swapi.controller;

import com.exam.swapi.model.starship.StarshipDetailDTO;
import com.exam.swapi.model.starship.StarshipPageResponseDTO;
import com.exam.swapi.service.starship.IStarshipService;
import com.exam.swapi.utils.ValidationUtils;
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

    @GetMapping
    public ResponseEntity<StarshipPageResponseDTO> listStarships() {
        return ResponseEntity.ok(starshipService.listStarships());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StarshipDetailDTO> getStarshipById(@PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(starshipService.getStarshipById(id));
    }
}
