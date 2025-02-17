package br.com.laaa.ContactList.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.laaa.ContactList.DTO.ContactDTO;
import br.com.laaa.ContactList.Mapper.ContactMapper;
import br.com.laaa.ContactList.model.Contact;
import br.com.laaa.ContactList.model.Person;
import br.com.laaa.ContactList.repository.ContactRepository;
import br.com.laaa.ContactList.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service responsible for managing contacts.
 * Provides methods to create, retrieve, update, and delete contacts.
 */
@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactMapper contactMapper;
    
	@Transactional
    public ContactDTO createContact(ContactDTO contactDTO) {
        Person person = personRepository.findById(contactDTO.personId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        Contact contact = contactMapper.toEntity(contactDTO);
        contact.setPerson(person);
        return contactMapper.toDTO(contactRepository.save(contact));
    }

    public List<ContactDTO> getAllContacts() {
        return contactRepository.findAll().stream()
                .map(contactMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO getContactById(Long id) {
        return contactRepository.findById(id)
                .map(contactMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    @Transactional
    public ContactDTO updateContact(Long id, ContactDTO contactDTO) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
        
        contact.setContact(contactDTO.contact());
        contact.setContactType(contactDTO.contactType());
        return contactMapper.toDTO(contactRepository.save(contact));
    }

    @Transactional
    public void deleteContact(Long id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contact not found");
        }
        contactRepository.deleteById(id);
    }
}