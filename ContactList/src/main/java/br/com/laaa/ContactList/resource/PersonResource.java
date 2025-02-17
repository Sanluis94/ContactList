package br.com.laaa.ContactList.resource;

import java.util.List;

public record PersonResource(Long id, String name, String address, String zipCode, String city, String state, List<ContactResource> contacts) {}
