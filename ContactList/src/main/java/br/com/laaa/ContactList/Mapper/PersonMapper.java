package br.com.laaa.ContactList.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.model.Person;

/**
 * Mapper interface responsible for converting Person entities to DTOs and vice versa.
 * Uses MapStruct for automatic mapping.
 */
@Mapper(componentModel = "spring")
public interface PersonMapper {
	
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO personDTO);
}


