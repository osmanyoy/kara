package com.alz.jee.customer.rest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.alz.jee.common.ErrorObject;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Path("/customer")
@SessionScoped
public class CustomerRest implements Serializable {

	private static final long serialVersionUID = 8504645495739943433L;

	private Map<Long, Customer> customerMap = new HashMap<>();

	@POST
	@Path("/save")
	public Response saveCustomer(@Valid Customer customer) {
		try {
			customerMap.put(customer.getId(),
			                customer);
			if (customer.getSurname()
			            .equals("osman")) {
				return Response.status(Status.BAD_GATEWAY)
				               .entity(new ErrorObject().setErrorCause(100)
				                                        .setErrorMessage("Ýsim osman olamaz"))
				               .build();
			}
			return Response.ok()
			               .entity(customer)
			               .build();
		} catch (Exception e) {
			return Response.status(Status.BAD_GATEWAY)
			               .entity(new ErrorObject().setErrorCause(500)
			                                        .setErrorMessage("Internal Error"))
			               .build();
		}
	}

	@POST
	@Path("/update")
	public Customer updateCustomer(Customer customer) {
		customerMap.put(customer.getId(),
		                customer);
		return customer;
	}

	@DELETE
	@Path("/remove/{cid}")
	public String deleteCustomer(@PathParam("cid") Long id) {
		customerMap.remove(id);
		return "OK";
	}

	@GET
	@Path("/get/{cid}")
	public Customer getCustomer(@PathParam("cid") Long id) {
		return customerMap.get(id);
	}

}
