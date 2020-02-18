package com.ksh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksh.entities.Person;
import com.ksh.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public void save(Person person) {
		personRepository.save(person);
	}
	
	public void delete(Person person) {
		personRepository.delete(person);
	}
	
	public void deleteById(Integer personId) {
		personRepository.deleteById(personId);
	}
	
	public Optional<Person> findById(Integer personId) {
		return personRepository.findById(personId);
	}
	
}
