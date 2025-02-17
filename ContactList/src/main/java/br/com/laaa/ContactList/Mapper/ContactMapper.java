package br.com.laaa.ContactList.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.laaa.ContactList.DTO.ContactDTO;
import br.com.laaa.ContactList.model.Contact;

/**
 * Mapper interface responsible for converting Contact entities to DTOs and vice versa.
 * Uses MapStruct for automatic mapping.
 */
@Mapper(componentModel = "spring", uses = br.com.laaa.ContactList.service.ContactService.class)
public interface ContactMapper {
    
    @Mapping(source = "person.id", target = "personId")
    ContactDTO toDTO(Contact contact);
    
    @Mapping(source = "personId", target = "person.id")
    Contact toEntity(ContactDTO contactDTO);
}