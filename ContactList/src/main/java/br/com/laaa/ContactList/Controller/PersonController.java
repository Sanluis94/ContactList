package br.com.laaa.ContactList.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laaa.ContactList.DTO.PersonDTO;
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
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Operation(summary = "Create a new person")
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO personDTO) {
        personService.createPerson(personDTO);
        return ResponseEntity.ok("Person created successfully!");
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
