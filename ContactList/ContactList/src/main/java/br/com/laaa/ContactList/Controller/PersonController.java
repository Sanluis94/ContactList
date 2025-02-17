package br.com.laaa.ContactList.Controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @Operation(summary = "Create a new person")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.createPerson(personDTO));
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
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.ok(personService.updatePerson(id, personDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a person by ID")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
