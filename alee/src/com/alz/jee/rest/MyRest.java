package com.alz.jee.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.alz.jee.common.Employee;

@Path("/m")
public class MyRest {

	@GET
	public String hello() {
		return "hello world";
	}

	@GET
	@Path("/n/{isim}/{soyisim}")
	public String hello2(@PathParam("isim") String name, @PathParam("soyisim") String surname) {
		return "hello : " + name + " " + surname;
	}

	@GET
	@Path("/n2")
	public String hello3(@QueryParam("isim") String name, @QueryParam("soyisim") String surname) {
		return "hello 3 : " + name + " " + surname;
	}

	@GET
	@Path("/n3/{yas}")
	public String hello4(@HeaderParam("isim") String name, @QueryParam("soyisim") String surname,
			@PathParam("yas") int age) {
		return "hello 4 : " + name + " " + surname + " " + age;
	}

	@GET
	@Path("/n4/{yas}")
	public String hello5(@MatrixParam("isim") String name, @MatrixParam("soyisim") String surname,
			@PathParam("yas") int age) {
		return "hello 5 : " + name + " " + surname + " " + age;
	}

	@POST
	@Path("/n5/{yas}")
	public String hello6(@FormParam("isim") String name, @FormParam("soyisim") String surname,
			@PathParam("yas") int age) {
		return "hello 6 : " + name + " " + surname + " " + age;
	}

	@POST
	@Path("/n6/{yas}")
	public String hello7(@BeanParam Employee emp) {
		return "hello 7 : " + emp.getName() + " " + emp.getSurname() + " " + emp.getAge();
	}

	@POST
	@Path("/n7/{yas}")
	public Employee hello8(@BeanParam Employee emp) {
		return emp;
	}

	@POST
	@Path("/n8")
	public Employee hello9 (Employee emp) {
		emp.setName("hello 9");
		return emp;
	}

}
