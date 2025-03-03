package br.com.laaa.ContactList.model;
import jakarta.persistence.*;

/**
 * Entity representing a contact.
 * Contains details such as contact type and person association.
 */
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer contactType;
    private String contact;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getContactType() {
		return contactType;
	}

	public void setContactType(int contactType) {
		this.contactType = contactType;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

   
}