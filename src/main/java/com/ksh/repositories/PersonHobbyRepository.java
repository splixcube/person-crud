package com.ksh.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksh.entities.PersonHobby;

@Repository
public interface PersonHobbyRepository extends JpaRepository<PersonHobby, Integer> {

	@Query("SELECT PH FROM PersonHobby PH WHERE PH.person.id = :personId")
	public List<PersonHobby> findByPersonId(@Param("personId") Integer personId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM PersonHobby PH WHERE PH.person.id = :personId")
	public void deleteByPersonId(@Param("personId") Integer personId);
	
}
