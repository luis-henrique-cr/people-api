package com.dio.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.peopleapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
}
