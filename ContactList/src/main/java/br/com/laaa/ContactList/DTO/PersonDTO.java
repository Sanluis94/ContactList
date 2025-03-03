package br.com.laaa.ContactList.DTO;

import java.util.List;

/**
 * Data Transfer Object (DTO) for Person.
 * Used to encapsulate person data, including a formatted address field.
 */
public record PersonDTO(
    Long id, 
    String name, 
    String email, 
    String phone, 
    String zipCode, 
    String address, 
    String city, 
    String state,
    Boolean active,  // Novo campo
    Integer contactType,  // Novo campo
    List<ContactDTO> contacts // Adiciona a lista de contatos diretamente no DTO de pessoa
) {
    @Override
    public String toString() {
        return String.format("%s, %s - CEP: %s - %s/%s", address, name, zipCode, city, state);
    }
}
