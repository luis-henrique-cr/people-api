package com.dio.peopleapi.mapper;

import org.springframework.stereotype.Component;

import com.dio.peopleapi.dto.request.PersonDTO;
import com.dio.peopleapi.entity.Person;

@Component
public class PersonMapper {
	
	public Person toModel(PersonDTO personDTO) {
		Person person = new Person(
				personDTO.getFirstName(), 
				personDTO.getLastName(), 
				personDTO.getCpf(), 
				personDTO.getBirthDate(), 
				personDTO.getPhones());
		person.setId(personDTO.getId());
		
		return person;
	}
	
	public PersonDTO toDTO(Person person) {
		PersonDTO personDTO = new PersonDTO(
				person.getFirstName(), 
				person.getLastName(), 
				person.getCpf(), 
				person.getBirthDate(), 
				person.getPhones());
		personDTO.setId(person.getId());
		
		return personDTO;
	}
}
