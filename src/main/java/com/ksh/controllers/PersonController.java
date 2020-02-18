package com.ksh.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.dtos.PersonDto;
import com.ksh.entities.Hobby;
import com.ksh.entities.Person;
import com.ksh.entities.PersonHobby;
import com.ksh.reqrep.CommonResponse;
import com.ksh.services.HobbyService;
import com.ksh.services.PersonHobbyService;
import com.ksh.services.PersonService;
import com.ksh.util.Constants;
import com.ksh.util.PersonUtil;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private HobbyService hobbyService;
	@Autowired
	private PersonHobbyService personHobbyService;
	
	@RequestMapping("/findAll")
	public CommonResponse findAll() {
		List<Person> persons = personService.findAll();
		List<PersonDto> personDtos = new ArrayList<>();
		persons.forEach(p -> {
			List<Hobby> hobbies = hobbyService.findByPersonId(p.getId());
			PersonDto dto = PersonUtil.entityToDto(p, hobbies);
			personDtos.add(dto);
		});
		CommonResponse cr = new CommonResponse(200, Constants.SUCCESS, personDtos);
		return cr;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public CommonResponse save(@RequestBody PersonDto personDto) {
		List<Hobby> hobbies = new ArrayList<>();
		Person person = null;
		if(personDto != null && personDto.getId() != null) {
			Optional<Person> optionalP = personService.findById(personDto.getId());
			if(optionalP.isPresent()) {
				person = optionalP.get();
			}
		}
		if(personDto != null) {
			if(personDto.getHobby() != null) {
				for(int i = 0; i < personDto.getHobby().length; i++) {
					Hobby hobby = hobbyService.findByName(personDto.getHobby()[i].toUpperCase());
					if(hobby == null) {
						Hobby newHobby = new Hobby(personDto.getHobby()[i].toUpperCase());
						newHobby = hobbyService.save(newHobby);
						hobbies.add(newHobby);
					} else {
						hobbies.add(hobby);
					}
				}
			}
		}
		
		Set<PersonHobby> personHobbies = new HashSet<>();
		if(person != null) {
			person = PersonUtil.dtoToEntity(personDto, person);
			personHobbyService.deleteByPersonId(person.getId());
		} else {
			person = PersonUtil.dtoToEntity(personDto);
		}
		for(Hobby h : hobbies) {
			PersonHobby personHobby = new PersonHobby();
			personHobby.setPerson(person);
			personHobby.setHobby(h);
			personHobbies.add(personHobby);
		}
		person.setPersonHobbies(personHobbies);
		personService.save(person);
		CommonResponse cr = new CommonResponse(200, Constants.SUCCESS);
		return cr;
	}

	@RequestMapping("/deleteById/{personId}")
	public CommonResponse deleteById(@PathVariable Integer personId) {
		personService.deleteById(personId);
		CommonResponse response = new CommonResponse(200, Constants.SUCCESS, "Person deleted Successfully.");
		return response;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public CommonResponse delete(@RequestBody PersonDto dto) {
		if(dto.getId() == null)
			return new CommonResponse(200, Constants.FAILURE, "PersonID is not present in request."); 
		Person person = PersonUtil.dtoToEntity(dto);
		personService.delete(person);
		return new CommonResponse(200, Constants.SUCCESS, "Person deleted Successfully.");
	}
}
