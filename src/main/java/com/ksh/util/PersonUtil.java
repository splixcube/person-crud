package com.ksh.util;

import java.util.List;

import com.ksh.dtos.PersonDto;
import com.ksh.entities.Hobby;
import com.ksh.entities.Person;

public class PersonUtil {

	public static PersonDto entityToDto(Person person, List<Hobby> hobbies) {
		PersonDto dto = new PersonDto();
		dto.setAge(person.getAge());
		dto.setFavouriteColor(person.getFavouriteColor());
		dto.setFirstName(person.getFirstName());
		dto.setId(person.getId());
		dto.setLastName(person.getLastName());
		if(hobbies != null) {
			int size = hobbies.size();
			String[] hobby = new String[size];
			for(int i = 0; i < size; i++) {
				hobby[i] = hobbies.get(i).getHobby();
			}
			dto.setHobby(hobby);
		}
		return dto;
	}
	
	public static Person dtoToEntity(PersonDto dto) {
		Person person = new Person();
		person = dtoToEntity(dto, person);
		return person;
	}
	
	public static Person dtoToEntity(PersonDto dto, Person person) {
		person.setAge(dto.getAge());
		person.setFavouriteColor(dto.getFavouriteColor());
		person.setFirstName(dto.getFirstName());
		person.setId(dto.getId());
		person.setLastName(dto.getLastName());
		return person;
	}
}
