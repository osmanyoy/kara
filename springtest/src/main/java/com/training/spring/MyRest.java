package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class MyRest {
	
	@Autowired
	private PersonService personService;


	@RequestMapping("/t1")
	public String test(@RequestParam("age") int age) {
		return personService.testMe(age);
	}
	
}
