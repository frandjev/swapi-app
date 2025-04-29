package com.exam.swapi.controller;

import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.people.IPeopleService;
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

    @GetMapping
    public ResponseEntity<PeoplePageResponseDTO> listPeople(@RequestParam(defaultValue = "1") int page) {
        if (page <= 0) {
            return ResponseEntity.badRequest().build();
        }
        PeoplePageResponseDTO response = peopleService.listPeople(page);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDetailDTO> getPersonById(@PathVariable String id) {
        PersonDetailDTO response = peopleService.findPersonById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/search")
    public ResponseEntity<PeoplePageResponseDTO> getPeopleByName(@RequestParam String name) {
        PeoplePageResponseDTO response = peopleService.findPersonByName(name);
        return ResponseEntity.ok(response);
    }
}
