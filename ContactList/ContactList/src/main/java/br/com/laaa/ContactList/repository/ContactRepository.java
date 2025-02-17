package br.com.laaa.ContactList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.laaa.ContactList.model.Contact;

/**
 * Repository interface for managing Contact entity persistence.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	Optional<Contact> findByPersonId(Long personId);
}
