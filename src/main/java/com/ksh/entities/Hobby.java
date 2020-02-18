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
@Table(name = "HOBBIES")
public class Hobby implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "HOBBY")
	private String hobby;
	@JsonIgnore
	@OneToMany(mappedBy = "hobby", cascade = CascadeType.ALL)
	private Set<PersonHobby> personHobbies;
	
	public Hobby() {
	}

	public Hobby(String hobby) {
		this.hobby = hobby;
	}
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
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
