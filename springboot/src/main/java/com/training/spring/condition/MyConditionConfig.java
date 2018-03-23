package com.training.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.spring.model.Person;

@Configuration
public class MyConditionConfig {

	
	@Bean
	@MyConditionAnno(age=120,name="abc")
	public Person createPerson() {
		Person person = new Person();
		person.setName("osman");
		return person;
	}

	@Bean
	@MyConditionAnno(age=40,name="xyz")
	public Person createPerson2() {
		Person person = new Person();
		person.setName("mehmet");
		return person;
	}

}
