package com.alz.jee.customer.ejb;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ejb")
public class MyTestEJBRest {

	@EJB
	private MyStatelessEJB myStatelessEJB;
	
	@GET
	public int index() {
		int result = myStatelessEJB.getCurrentIndex();
		System.out.println("iþlem : " + result);
		return myStatelessEJB.getCurrentIndex();
	}
	
}
