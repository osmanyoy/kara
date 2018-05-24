package com.alz.jee.customer.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.alz.jee.common.ErrorObject;

@Path("/cnew")
public class CustomerNewRest {

	@EJB
	private CustomerDAO custDao;
	
	@EJB
	private AccountDAO accDao;

	@POST
	@Path("/save")
	public Response saveCustomer(@Valid Customer customer) {
		try {
			List<Account> accountList = new ArrayList<>();

			Account tl = new Account();
			tl.setAccountType("TL");
			tl.setAmount(0);
			tl.setCustomer(customer);

			accountList.add(tl);

			Account usd = new Account();
			usd.setAccountType("USD");
			usd.setAmount(0);
			usd.setCustomer(customer);

			accountList.add(usd);

			Account euro = new Account();
			euro.setAccountType("EURO");
			euro.setAmount(0);
			euro.setCustomer(customer);

			accountList.add(euro);

			customer.setAccounts(accountList);

			custDao.insert(customer);
			return Response.ok().entity("OK").build();
		} catch (Exception e) {
			return Response.status(Status.BAD_GATEWAY)
			               .entity(new ErrorObject().setErrorCause(500)
			                                        .setErrorMessage("Internal Error"))
			               .build();
		}
	}

	@GET
	@Path("/addamount/{cid}/{type}/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account addAmountToAccount(@PathParam("cid") long cid,
	                                  @PathParam("type") String accountType,
	                                  @PathParam("amount") int amount) {
		Customer customer = custDao.getCustomer(cid);
		if (customer != null) {
			List<Account> accounts = customer.getAccounts();
			for (Account account : accounts) {
				if (account.getAccountType().equals(accountType)) {
					int amount2 = account.getAmount();
					account.setAmount(amount2 + amount);
					accDao.update(account);
					return account;
				}
			}
		}
		return null;
	}

}
