package com.ksh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksh.entities.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Integer> {

	@Query("SELECT H FROM Hobby H INNER JOIN H.personHobbies PH WHERE PH.person.id = :id")
	public List<Hobby> findByPersonId(@Param("id") Integer id);

	public Hobby findByHobby(String hobby);
}
