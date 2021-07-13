package com.dio.peopleapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
                
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	            
	@Column(nullable = false, name = "first_name")
	private String firstName;
	        
	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@Column(nullable = false)
	private List<Phone> phones;

	public Person() {
	}

	public Person(String firstName, String lasteName, String cpf, LocalDate birthDate, List<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lasteName;
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

	public void setLastName(String lasteName) {
		this.lastName = lasteName;
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
