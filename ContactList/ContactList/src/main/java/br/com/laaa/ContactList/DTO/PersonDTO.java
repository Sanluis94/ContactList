package br.com.laaa.ContactList.DTO;

/**
 * DTO for Person entity.
 */

public record PersonDTO(Long id, String name, String address, String zipCode, String city, String state) {
    @Override
    public String toString() {
        return String.format("%s, %s - CEP: %s - %s/%s", address, name, zipCode, city, state);
    }
}