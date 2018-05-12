package com.training.spring.kkb.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import com.training.spring.kkb.rest.Person;


@Endpoint(id="testendpoint")
@Component
public class MyEndPoint {
	
	@ReadOperation
	public Person getAdres() {
		Person person = new Person();
		person.setName("osman");
		person.setSurname("yay");
		person.setAge(10);
		return person;
	}
	
	@ReadOperation
	public Person getAdres2(@Selector String town) {
		Person person = new Person();
		person.setName("osman");
		person.setSurname(town);
		person.setAge(20);
		return person;
	}

}
