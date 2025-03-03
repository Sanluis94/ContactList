package br.com.laaa.ContactList.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.Mapper.PersonMapper;
import br.com.laaa.ContactList.model.Contact;
import br.com.laaa.ContactList.model.Person;
import br.com.laaa.ContactList.repository.ContactRepository;
import br.com.laaa.ContactList.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service responsible for managing people.
 * Allows creating, listing, retrieving, updating, and deleting person records.
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
	private final ContactRepository contactRepository;
	private Person person;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper, ContactRepository contactRepository) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.contactRepository = contactRepository;
    }

    public PersonDTO getPersonById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PersonDTO createPerson(PersonDTO personDTO) {
        if (personDTO.name() == null || personDTO.email() == null || personDTO.phone() == null) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos");
        }

        person = personMapper.toEntity(personDTO);

        person = personRepository.save(person);

        if (personDTO.contacts() != null) {
            personDTO.contacts().forEach(contactDTO -> {
                Contact contact = new Contact();
                contact.setContact(contactDTO.contact());
                contact.setContactType(contactDTO.contactType());
                contact.setPerson(person);
                contactRepository.save(contact);
            });
        }

        return personMapper.toDTO(person);
    }


    @Transactional
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        
        person.setName(personDTO.name());
        person.setAddress(personDTO.address());
        person.setZipCode(personDTO.zipCode());
        person.setCity(personDTO.city());
        person.setState(personDTO.state());

        if (personDTO.contacts() != null) {
           
            contactRepository.deleteByPerson(person);
            
            personDTO.contacts().forEach(contactDTO -> {
                Contact contact = new Contact();
                contact.setContact(contactDTO.contact());
                contact.setContactType(contactDTO.contactType());
                contact.setPerson(person); 
                contactRepository.save(contact);
            });
        }
        
        return personMapper.toDTO(personRepository.save(person));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}