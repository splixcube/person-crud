package com.ksh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksh.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
