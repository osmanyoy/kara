package com.training.spring.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.ws.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.model.Person;

@RestController
@RequestMapping("/real")
@Validated
public class RealRest {

	@RequestMapping("/r1")
	public Person processPerson(@RequestParam("name") String name,
	                            @RequestParam("age") int age)
	        throws MyException {

		if (age < 10 || age > 120) {
			throw new MyException("yaş 10 ile 120 arasında olmalı", 1292);
		}
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		return person;
	}

	@RequestMapping("/r2")
	public Person processPerson2(@NonNull @Size(min = 2, max = 20, message = "Bu böyle olmaz değiştir") @RequestParam("name") String name,
	                             @Max(120) @Min(10) @RequestParam("age") int age) {

		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		return person;
	}

	@RequestMapping("/r3")
	public ResponseEntity<?> processPerson3(@RequestParam("name") String name,
	                                        @RequestParam("age") int age) {
		ResponseEntity<?> retVal = null;
		if (age < 10 || age > 120) {
			retVal = ResponseEntity.status(475).body(new ErrorObj("10 ila 120 arasında olmalı", 3737));
		} else {
			Person person = new Person();
			person.setName(name);
			person.setAge(age);
			retVal = ResponseEntity.ok(person);
		}
		return retVal;
	}

	@RequestMapping("/r4")
	public ResponseEntity<?> processPerson4(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		ResponseEntity<?> retVal = null;
		String name = httpServletRequest.getParameter("name");
		int age = Integer.parseInt(httpServletRequest.getParameter("age"));
		if (age < 10 || age > 120) {
			retVal = ResponseEntity.status(475).body(new ErrorObj("10 ila 120 arasında olmalı", 3737));
		} else {
			Person person = new Person();
			person.setName(name);
			person.setAge(age);
			retVal = ResponseEntity.ok(person);
		}
		return retVal;
	}

	@RequestMapping("/r5")
	public void processPerson5(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
		String name = httpServletRequest.getParameter("name");
		int age = Integer.parseInt(httpServletRequest.getParameter("age"));
		httpServletResponse.getOutputStream().println("name : " + name);
	}

}
