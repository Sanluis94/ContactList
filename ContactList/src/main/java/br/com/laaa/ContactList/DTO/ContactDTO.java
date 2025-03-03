package br.com.laaa.ContactList.DTO;

/**
 * Data Transfer Object (DTO) for Contact.
 * Used to encapsulate contact data and expose it in a structured format.
 */
public record ContactDTO(Long id, Integer contactType, String contact, Long personId) {
}
