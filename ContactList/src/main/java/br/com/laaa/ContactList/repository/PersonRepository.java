package br.com.laaa.ContactList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.laaa.ContactList.model.Person;

/**
 * Repository interface for managing Person entity persistence.
 * Extends JpaRepository to provide CRUD operations.
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}