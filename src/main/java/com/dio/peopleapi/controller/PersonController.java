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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Operation(summary = "Cadastra uma pessoa.")
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
	@Operation(summary = "Pega um cadastro de pessoa pelo ID.")
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) {
		return personService.findById(id);
	}
	
	@Operation(summary = "Pega uma lista de 20 cadastros dependendo da página.")
	@GetMapping("/page/{pageNum}")
	public List<PersonDTO> getPage(@PathVariable Long pageNum) {
		return personService.getPage(pageNum);
	}
	
	@Operation(summary = "Deleta o cadastro de uma pessoa.")
	@DeleteMapping("/{id}")
	public MessageResponseDTO deleteById(@PathVariable Long id) {
		return personService.deleteById(id);
	}
	
	@Operation(summary = "Atualiza o cadastro de uma pessoa.")
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
		return personService.updateById(id, personDTO);
	}
	
}
