package com.ssoop.blog.controller;

import com.ssoop.blog.dto.PersonDTO;
import com.ssoop.blog.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Integer id) {
        PersonDTO person = service.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getPeople() {
        List<PersonDTO> people = service.getPersonList();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> savePerson(@RequestBody PersonDTO personDTO) {
        service.addPerson(personDTO);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Integer id, @RequestBody PersonDTO personDTO) {
        service.updatePerson(id, personDTO);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
