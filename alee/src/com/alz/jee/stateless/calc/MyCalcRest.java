package com.alz.jee.stateless.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/calc")
@SessionScoped
public class MyCalcRest implements Serializable {

	private int total;
	
	@EJB
	private MyCalcEJB mce;
	
	@Path("/add/{tutar}")
	@GET
	public int add(@PathParam("tutar") int amount) {
		total = mce.add(total, amount);
		return total;
	}
	
	@Path("/subs/{tutar}")
	@GET
	public int subs(@PathParam("tutar") int amount) {
		total = mce.subs(total, amount);
		return total;
	}

}
