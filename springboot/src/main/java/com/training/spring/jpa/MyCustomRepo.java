package com.training.spring.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MyCustomRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Transactional(propagation = Propagation.NEVER)
	public void yaz(Customer customer) {
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		try {
			// entityManager.joinTransaction();

			entityManager2.getTransaction().begin();
			entityManager2.persist(customer);
			entityManager2.getTransaction().commit();
		} catch (Exception e) {
			entityManager2.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = IllegalAccessException.class, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public void yaz2(Customer customer) {
		// if (customer.getAge() > 18) {
		// throw new IllegalArgumentException();
		// }
		entityManager.persist(customer);
	}
	
	public Customer fill(Customer customer) {
		Customer mergedCustomer = entityManager.merge(customer);
		mergedCustomer.getAccounts();
		mergedCustomer.getCed();
		return mergedCustomer;
	}
	
	public List<Customer> fillAll(List<Customer> customerList) {
		List<Customer> mergedCustomers =new  ArrayList<>();
		for (Customer customer : customerList) {
			Customer mergedCustomer = entityManager.merge(customer);
			List<Account> accounts = mergedCustomer.getAccounts();
			CustomerExtraData ced = mergedCustomer.getCed();
			System.out.println("extra1 : " + ced.getTckn());
			mergedCustomers.add(mergedCustomer);
		}
		return mergedCustomers;
	}

}
