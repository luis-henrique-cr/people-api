package com.dio.peopleapi.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.dio.peopleapi.entity.Phone;

public class PersonDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String lastName;

	@NotEmpty
	@CPF
	private String cpf;

	private LocalDate birthDate;

	@NotEmpty
	@Valid
	private List<Phone> phones;

	public PersonDTO() {
	}

	public PersonDTO(String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phones = phones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
