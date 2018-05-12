package com.training.spring.kkb.rest;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Thrown;

@RestController
@RequestMapping("/rest")
public class RestTraining {

	@RequestMapping(path = "/hello1/{isim}/{soy}", method = RequestMethod.GET)
	public String hello1(@PathVariable("isim") String name,
	                     @PathVariable("soy") String surname,
	                     @RequestParam("yas") int age) {
		return "Hello " + name + " " + surname + " age : " + age;
	}

	@RequestMapping(path = "/hello2/{isim}", method = RequestMethod.GET)
	public String hello2(@PathVariable("isim") String name,
	                     @RequestHeader("soy") String surname,
	                     @RequestParam("yas") int age) {
		return "Hello " + name + " " + surname + " age : " + age;
	}

	@RequestMapping(path = "/hello3", method = RequestMethod.GET)
	public String hello3(@MatrixVariable("isim") String name) {
		return "Hello " + name;
	}

	@RequestMapping(path = "/hello4", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
	        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
	                MediaType.APPLICATION_XML_VALUE })
	public Person hello4(@Validated @RequestBody Person person) throws MyException{
		person.setName("ali");
		if (person.getAge() > 50) {
			throw new MyException("50 den büyük olamaz", 100);
		}
		return person;
	}
	
	@RequestMapping(path = "/hello5", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
	        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
	                MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> hello5(@RequestBody Person person) throws MyException{
		person.setName("ali");
		if (person.getAge() > 50) {
			ErrorObject errorObject = new ErrorObject();
			errorObject.setMsg("50 den büyük olamaz");
			errorObject.setErrorIndex(100);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
		}
		return ResponseEntity.ok(person);
	}

	@RequestMapping(path = "/hello6")
	public void hello6(HttpServletRequest request,HttpServletResponse response) throws MyException{
		try {
			response.getOutputStream().println("Cevap");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(path = "/hello7", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
	        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
	                MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> hello7(@RequestBody Person person,HttpServletRequest request,Principal principal) throws MyException{
		person.setName("ali");
		if (person.getAge() > 50) {
			ErrorObject errorObject = new ErrorObject();
			errorObject.setMsg("50 den büyük olamaz");
			errorObject.setErrorIndex(100);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorObject);
		}
		return ResponseEntity.ok(person);
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex) {
		if (ex instanceof MyException) {
			MyException me = (MyException) ex;
			return "Error oluştu : " + me.getMsg() + " index : " + me.getErrorIndex();
		} else if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
			return "Error oluştu : " + manve.getMessage() + " index : " + 500;
		}
		return "Error oluştu";
	}

}
