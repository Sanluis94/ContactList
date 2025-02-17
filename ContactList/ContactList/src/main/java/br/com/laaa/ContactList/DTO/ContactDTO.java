package br.com.laaa.ContactList.DTO;

/**
 * DTO for Contact entity.
 */
public record ContactDTO(Long id, int contactType, String contact, Long personId) {
}
