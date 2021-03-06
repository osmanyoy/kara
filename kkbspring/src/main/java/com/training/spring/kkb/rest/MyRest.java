package com.training.spring.kkb.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.kkb.IMyInter;
import com.training.spring.kkb.MyQAnno;
import com.training.spring.kkb.security.MySecurity;

@RestController
@RequestMapping("/r")
public class MyRest {

	private static Map<String, Person> personMap = new HashMap<>();

	public MyRest() {
		for (int i = 0; i < 1_000; i++) {
			Person person = new Person();
			person.setName("osman" + i);
			person.setSurname("yay" + i);
			person.setAge(i);
			personMap.put(person.getName(),
			              person);
		}
	}

	@Autowired
	private IMyInter myImpl1;

	@Autowired
	@MyQAnno
	private IMyInter inter;

	@Autowired
	@Qualifier("ahmet")
	private IMyInter inter3;

	@RequestMapping("/m1")
	@PreAuthorize("hasAuthority('yetkili')")
	public String m1() {
		return myImpl1.execute();
	}
	
	@MySecurity(authority="yetkili")
	@RequestMapping("/m2")
	public String m2() {
		return inter.execute();
	}

	@RequestMapping("/m3")
	public String m3() {
		return inter3.execute();
	}

}
