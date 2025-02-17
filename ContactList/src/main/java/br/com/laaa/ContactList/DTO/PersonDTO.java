package br.com.laaa.ContactList.DTO;

/**
 * Data Transfer Object (DTO) for Person.
 * Used to encapsulate person data, including a formatted address field.
 */
public record PersonDTO(Long id, String name, String address, String zipCode, String city, String state) {
    @Override
    public String toString() {
        return String.format("%s, %s - CEP: %s - %s/%s", address, name, zipCode, city, state);
    }
}