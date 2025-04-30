package com.exam.swapi.controller;

import com.exam.swapi.model.people.PeoplePageResponseDTO;
import com.exam.swapi.model.people.PeopleSearchResponseDTO;
import com.exam.swapi.model.people.PersonDetailDTO;
import com.exam.swapi.service.people.IPeopleService;
import com.exam.swapi.utils.ValidationUtils;
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
        ValidationUtils.requirePositive(page, "page");
        return ResponseEntity.ok(peopleService.listPeople(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDetailDTO> getPersonById(@PathVariable String id) {
        ValidationUtils.requireNotEmpty(id, "id");
        return ResponseEntity.ok(peopleService.findPersonById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<PeopleSearchResponseDTO> getPeopleByName(@RequestParam String name) {
        ValidationUtils.requireNotEmpty(name, "name");
        return ResponseEntity.ok(peopleService.findPersonByName(name));
    }
}
