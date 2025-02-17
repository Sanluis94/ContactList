package br.com.laaa.ContactList.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.laaa.ContactList.DTO.ContactDTO;
import br.com.laaa.ContactList.service.ContactService;

import java.util.List;

/**
 * REST controller responsible for exposing endpoints for contact management.
 * Uses ContactService to handle data operations.
 */
@RestController
@RequestMapping("/api/contacts")
@Tag(name = "Contacts", description = "Endpoints for managing contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @Operation(summary = "Create a new contact")
    public ResponseEntity<String> createContact(@RequestBody ContactDTO contactDTO) {
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
