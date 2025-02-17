package br.com.laaa.ContactList.resource;

import java.util.List;

import br.com.laaa.ContactList.DTO.ContactDTO;

public record ContactListResource(List<ContactDTO> contacts) {}
