package com.alz.jee.customer.rest;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class CustomerDAO {
	
	@PersistenceContext(unitName = "alee")
	private EntityManager em;
	
	public boolean insert(Customer customer) {
		em.persist(customer);
		return true;
	}
	
	public boolean update(Customer customer) {
		em.merge(customer);
		return true;
	}
	
	public Customer getCustomer(long cid) {
		return em.find(Customer.class, cid);
	}
	
}
