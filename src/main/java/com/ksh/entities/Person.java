package com.ksh.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

	private static final long serialVersionUID = -1020782595030907490L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private Integer age;
	@Column(name = "FAVOURITE_COLOR")
	private String favouriteColor;
	@JsonIgnore
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<PersonHobby> personHobbies;
	
	public Set<PersonHobby> getPersonHobbies() {
		return personHobbies;
	}
	public void setPersonHobbies(Set<PersonHobby> personHobbies) {
		this.personHobbies = personHobbies;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFavouriteColor() {
		return favouriteColor;
	}
	public void setFavouriteColor(String favouriteColor) {
		this.favouriteColor = favouriteColor;
	}
	
}
