package com.ksh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksh.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {	

//	public User findByUserName(String userName);
}
