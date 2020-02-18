package com.ksh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksh.entities.Hobby;
import com.ksh.services.HobbyService;

@RestController
@RequestMapping("/hobby")
@CrossOrigin(value="http://localhost:4200")
public class HobbyController {

	@Autowired
	private HobbyService hobbyService;
	
	@RequestMapping("/findAll")
	private List<Hobby> findAll() {
		return hobbyService.findAll();
	}
	
	@RequestMapping("/findByPersonId/{id}")
	private List<Hobby> findByPersonId(@PathVariable("id") Integer personId) {
		System.out.println(personId);
		return hobbyService.findByPersonId(personId);
	}
	
	@RequestMapping("/findByName/{name}")
	private Hobby findByName(@PathVariable("name") String name) {
		System.out.println(name);
		return hobbyService.findByName(name.toUpperCase());
	}
}
