package com.training.spring.rest;

import java.security.Principal;
import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.training.spring.IMyInt;
import com.training.spring.model.Person;

@RestController
@RequestScope
@RequestMapping("/test")
public class MyRest {

	@Autowired
	@Qualifier("osman")
	private IMyInt ttt;

	@Autowired
	@Qualifier("mehmet")
	private IMyInt ttt2;

	@Autowired
	@Qualifier("test1")
	private IMyInt ttt3;

	@Autowired
	@Qualifier("veli")
	private IMyInt ttt4;

	@RequestMapping
	public String helloWorld(Authentication  principal) {
		User user = (User)principal.getPrincipal();
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			String authority = grantedAuthority.getAuthority();
			System.out.println(authority);
		}
		if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))){
			return "Hello Admin";
		}
		return "Hello Köle";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(path = "/s1")
	public String secureMethod1() {
		return "OK";
	}

	@RequestMapping(path = "/m")
	public String method1() {
		return ttt4.execute();
	}

	@RequestMapping(path = "/m", method = RequestMethod.POST)
	public String method2() {
		return ttt.execute();
	}

	@RequestMapping(path = "/m3/{abc}/hello/{xyz}")
	public String method3(@RequestParam("name") String str,
	                      @RequestParam("age") int yas,
	                      @PathVariable("abc") String dep,
	                      @PathVariable("xyz") String hhh,
	                      @RequestHeader("user") String user) {

		System.out.println("str : " + str + " age : " + yas + " dep : " + dep + " hhh : " + hhh + " user : " + user
		        );
		return "Hello " + str + " - " + yas;
	}

	@RequestMapping(path = "/m4", method = RequestMethod.POST)
	public String method4(@RequestBody Person person) {
		System.out.println(person);
		return "Hello " + person.getName();
	}

	@RequestMapping(path = "/m5", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
	        MediaType.APPLICATION_XML_VALUE })
	public String method5(@RequestBody Person person) {
		System.out.println(person);
		return "Hello " + person.getName();
	}

	@RequestMapping(path = "/m6", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
	        MediaType.APPLICATION_XML_VALUE },produces = { MediaType.APPLICATION_JSON_VALUE,
	    	        MediaType.APPLICATION_XML_VALUE })
	public Person method6(@Validated @RequestBody Person person) {
		System.out.println(person);
		return person;
	}

	@RequestMapping(path = "/m7", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE,
	    	        MediaType.APPLICATION_XML_VALUE })
	public Person method7(Person person) {
		System.out.println(person);
		person.setName("test_" + person.getName()) ;
		return person;
	}

}
