package br.com.laaa.ContactList.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.laaa.ContactList.DTO.PersonDTO;
import br.com.laaa.ContactList.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO personDTO);
}


