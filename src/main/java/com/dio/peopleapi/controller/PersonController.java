package com.dio.peopleapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dio.peopleapi.dto.request.PersonDTO;
import com.dio.peopleapi.dto.response.MessageResponseDTO;
import com.dio.peopleapi.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) {
		return personService.findById(id);
	}
	
	@GetMapping("/page/{pageNum}")
	public List<PersonDTO> getPage(@PathVariable Long pageNum) {
		return personService.getPage(pageNum);
	}
	
	@DeleteMapping("/{id}")
	public MessageResponseDTO deleteById(@PathVariable Long id) {
		return personService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
		return personService.updateById(id, personDTO);
	}
	
}
