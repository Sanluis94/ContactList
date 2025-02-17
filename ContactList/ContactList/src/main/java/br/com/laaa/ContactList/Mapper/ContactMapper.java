package br.com.laaa.ContactList.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.laaa.ContactList.DTO.ContactDTO;
import br.com.laaa.ContactList.model.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    
    @Mapping(source = "person.id", target = "personId")
    ContactDTO toDTO(Contact contact);
    
    @Mapping(source = "personId", target = "person.id")
    Contact toEntity(ContactDTO contactDTO);
}