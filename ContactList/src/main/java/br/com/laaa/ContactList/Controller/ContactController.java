package br.com.laaa.ContactList.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laaa.ContactList.DTO.ContactDTO;
import br.com.laaa.ContactList.model.Contact;
import br.com.laaa.ContactList.model.Person;
import br.com.laaa.ContactList.repository.PersonRepository;
import br.com.laaa.ContactList.service.ContactService;

import java.util.List;

/**
 * REST controller responsible for exposing endpoints for contact management.
 * Uses ContactService to handle data operations.
 */
@RestController
@RequestMapping("/api/contacts")
@Tag(name = "Contacts", description = "Endpoints for managing contacts")
@CrossOrigin(origins = "http://localhost:4200") // Permite requisições do Angular
public class ContactController {

    private final ContactService contactService;
    private final PersonRepository personRepository;

    public ContactController(ContactService contactService, PersonRepository personRepository) {
        this.contactService = contactService;
        this.personRepository = personRepository;
    }

    @PostMapping
    @Operation(summary = "Create a new contact")
    public ResponseEntity<String> createContact(@RequestBody ContactDTO contactDTO) {
        Person person = personRepository.findById(contactDTO.personId()).orElseThrow(() -> new RuntimeException("Person not found"));
        Contact contact = new Contact();
        contact.setContact(contactDTO.contact());
        contact.setContactType(contactDTO.contactType());
        contact.setPerson(person);
        contactService.createContact(contactDTO);
        return ResponseEntity.ok("Contact created successfully!");
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get a contact by ID")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @GetMapping
    @Operation(summary = "List all contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a contact by ID")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        contactService.updateContact(id, contactDTO);
        return ResponseEntity.ok("Contact updated successfully!");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a contact by ID")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully!");
    }
}
