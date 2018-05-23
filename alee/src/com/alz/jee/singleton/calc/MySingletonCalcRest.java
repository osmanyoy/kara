package com.alz.jee.singleton.calc;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/calc3")
@SessionScoped
public class MySingletonCalcRest implements Serializable {
	
	@EJB
	private MySingletonCalcEJB msce;
	
	@EJB
	private MyTotalHolderEJB mthe;
	
	@Path("/add/{tutar}")
	@GET
	public int add(@PathParam("tutar") int amount) {
		mthe.setTotal(msce.add(mthe.getTotal(),amount));
		return mthe.getTotal();
	}
	
	@Path("/subs/{tutar}")
	@GET
	public int subs(@PathParam("tutar") int amount) {
		mthe.setTotal(msce.subs(mthe.getTotal(),amount));
		return mthe.getTotal();
	}

}
