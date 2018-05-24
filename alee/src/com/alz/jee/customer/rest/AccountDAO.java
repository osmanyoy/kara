package com.alz.jee.customer.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AccountDAO {
	@PersistenceContext(unitName = "alee")
	private EntityManager em;
	
	public boolean update(Account acc) {
		em.merge(acc);
		return true;
	}

}
