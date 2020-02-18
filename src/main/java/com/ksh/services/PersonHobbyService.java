package com.ksh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksh.entities.PersonHobby;
import com.ksh.repositories.PersonHobbyRepository;

@Service
public class PersonHobbyService {

	@Autowired
	private PersonHobbyRepository personHobbyRepository;
	
	public List<PersonHobby> findByPersonId(Integer personId) {
		return personHobbyRepository.findByPersonId(personId);
	}
	
	public void deleteByPersonId(Integer personId) {
		personHobbyRepository.deleteByPersonId(personId);
	}

}
