package com.dio.peopleapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dio.peopleapi.dto.request.PersonDTO;
import com.dio.peopleapi.dto.response.MessageResponseDTO;
import com.dio.peopleapi.entity.Person;
import com.dio.peopleapi.exception.PersonNotFoundException;
import com.dio.peopleapi.mapper.PersonMapper;
import com.dio.peopleapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person savedPerson = personRepository.save(personMapper.toModel(personDTO));
		return new MessageResponseDTO("Person created - ID " + savedPerson.getId());
	}

	public List<PersonDTO> getPage(Long pageNum) {
		return personRepository.findAll(PageRequest.of(pageNum.intValue(), 20))
				.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) {
		Person person = verifyIfExists(id);
		return personMapper.toDTO(person);
	}

	public MessageResponseDTO deleteById(Long id) {
		verifyIfExists(id);
		personRepository.deleteById(id);
		return createMessageResponse("Person deleted - ID ", id);
	}
	
	public MessageResponseDTO updateById(Long id, PersonDTO personDTO) {
		verifyIfExists(id);
		personDTO.setId(id);
		Person personToUpdate = personMapper.toModel(personDTO);
		
		personRepository.save(personToUpdate);
		return createMessageResponse("Person updated - ID ", id);
	}

	private Person verifyIfExists(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
		return person;
	}
	
	private MessageResponseDTO createMessageResponse(String message, Long id) {
		return new MessageResponseDTO(message + id);
	}

}
