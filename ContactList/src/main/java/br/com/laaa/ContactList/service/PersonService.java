package br.com.laaa.ContactList.service;

import org.springframework.stereotype.Service;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.Mapper.PersonMapper;
import br.com.laaa.ContactList.model.Person;
import br.com.laaa.ContactList.repository.PersonRepository;

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

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        return personMapper.toDTO(personRepository.save(person));
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

    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        person.setName(personDTO.name());
        person.setAddress(personDTO.address());
        person.setZipCode(personDTO.zipCode());
        person.setCity(personDTO.city());
        person.setState(personDTO.state());
        return personMapper.toDTO(personRepository.save(person));
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}