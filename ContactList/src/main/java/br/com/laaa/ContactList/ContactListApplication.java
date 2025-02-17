package br.com.laaa.ContactList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.laaa.ContactList")
public class ContactListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactListApplication.class, args);
	}

}
