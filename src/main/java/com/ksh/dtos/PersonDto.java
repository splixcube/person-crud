package com.ksh.dtos;

public class PersonDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String favouriteColor;
	private String[] hobby;
	
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
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
}
