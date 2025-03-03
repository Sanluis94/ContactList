package br.com.laaa.ContactList.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.model.Person;
import br.com.laaa.ContactList.repository.PersonRepository;
import br.com.laaa.ContactList.service.PersonService;

import java.util.List;

/**
 * REST controller responsible for handling HTTP requests for persons.
 * Provides endpoints to manage persons and their associated contacts.
 * Delegates business logic to PersonService.
 */
@RestController
@RequestMapping("/api/people")
@Tag(name = "Persons", description = "Endpoints for managing persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @PostMapping
    @Operation(summary = "Create a new person")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        try {
            PersonDTO createdPerson = personService.createPerson(personDTO);
            return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a person by ID")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @GetMapping
    @Operation(summary = "List all persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a person by ID")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        personService.updatePerson(id, personDTO);
        return ResponseEntity.ok("Person updated successfully!");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a person by ID")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok("Person deleted successfully!");
    }
}
