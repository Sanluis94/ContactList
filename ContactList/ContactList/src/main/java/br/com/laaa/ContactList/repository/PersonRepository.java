package br.com.laaa.ContactList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.laaa.ContactList.model.Person;

/**
 * Repository interface for managing Person entities.
 * This interface extends JpaRepository, providing CRUD operations.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}