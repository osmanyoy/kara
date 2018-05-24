package com.alz.jee.rest;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alz.jee.common.Employee;

@WebService(targetNamespace="http://alianz.com")
@Path("/m")
public class MyRest {

	@GET
	public String hello() {
		return "hello world";
	}

	@GET
	@Path("/n/{isim}/{soyisim}")
	public String hello2(@PathParam("isim") @WebParam(name = "name") String name,
	                     @PathParam("soyisim") @WebParam(name = "surname") String surname) {
		return "hello : " + name + " " + surname;
	}

	@GET
	@Path("/n2")
	@WebMethod(exclude = true)
	public String hello3(@QueryParam("isim") String name,
	                     @QueryParam("soyisim") String surname) {
		return "hello 3 : " + name + " " + surname;
	}

	@GET
	@Path("/n3/{yas}")
	public String hello4(@HeaderParam("isim") String name,
	                     @QueryParam("soyisim") String surname,
	                     @PathParam("yas") int age) {
		return "hello 4 : " + name + " " + surname + " " + age;
	}

	@GET
	@Path("/n4/{yas}")
	public String hello5(@MatrixParam("isim") String name,
	                     @MatrixParam("soyisim") String surname,
	                     @PathParam("yas") int age) {
		return "hello 5 : " + name + " " + surname + " " + age;
	}

	@POST
	@Path("/n5/{yas}")
	public String hello6(@FormParam("isim") String name,
	                     @FormParam("soyisim") String surname,
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
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee hello9(Employee emp) {
		emp.setName("hello 9");
		return emp;
	}

}
