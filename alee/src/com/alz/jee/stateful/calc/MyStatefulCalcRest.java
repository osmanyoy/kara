package com.alz.jee.stateful.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/calc2")
@SessionScoped
public class MyStatefulCalcRest implements Serializable {
	
	@EJB
	private MyStatefulCalcEJB msce;
	
	@Path("/add/{tutar}")
	@GET
	public int add(@PathParam("tutar") int amount) {
		return msce.add(amount);
	}
	
	@Path("/subs/{tutar}")
	@GET
	public int subs(@PathParam("tutar") int amount) {
		return  msce.subs(amount);
	}

}
