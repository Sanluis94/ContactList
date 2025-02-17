package br.com.laaa.ContactList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.laaa.ContactList.model.Contact;

/**
 * Repository interface for managing Contact entities.
 * This interface extends JpaRepository, providing CRUD operations.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
	Optional<Contact> findByPersonId(Long personId);
}
