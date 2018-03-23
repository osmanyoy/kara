package com.training.spring.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class JpaRest {
	
	@Autowired
	private MyCustomRepo customRepo;
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private JpaContext jpx;

	
	@RequestMapping("/custom1")
	public String writeCustomRepo(@RequestParam("name") String name) {
		customRepo.yaz(createCustomer(name));
		return "OK";
	}
	
	@RequestMapping("/custom2")
	public String writeCustomRepo2(@RequestParam("name") String name) {
		customRepo.yaz2(createCustomer(name));
		return "OK";
	}
	
	@RequestMapping("/sd")
	public String writeRepo(@RequestParam("name") String name) {
		customerRepo.save(createCustomer(name));
		return "OK";
	}
	
	@RequestMapping("/sdg")
	public List<Customer> getCustomers(@RequestParam("name") String name) {
		
		List<Customer> isimdenCoz = customerRepo.isimdenCoz(name);
		EntityManager em = jpx.getEntityManagerByManagedType(Customer.class);
		em.clear();
		for (Customer customer : isimdenCoz) {
			em.detach(customer);
		}
		for (Customer customer : isimdenCoz) {
			CustomerExtraData ced = customer.getCed();
			System.out.println(ced);
		}
		return isimdenCoz;
//		List<Customer> fillAllCustomers = customRepo.fillAll(isimdenCoz);
//		return fillAllCustomers;
	}
	
	@RequestMapping("/sdg2")
	public List<Customer> getCustomersEagrly(@RequestParam("name") String name) {
		List<Customer> isimdenCoz = customerRepo.findCustomTestEagerly(name);
		return isimdenCoz;
	}
	

	private Customer createCustomer(String name) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSurname("yay");
		customer.setAge(55);
		customer.setCustomerMiddleName("middle");
		customer.setExtra1("extra1");
		customer.setExtra2("extra2");
		customer.setMyDate(new Date());
		customer.setMyEnum(EMyEnum.TEST1);
		customer.setOther1("other1");
		customer.setOther2("other2");
		customer.setTemp("temp");
		MyExtra myExtra = new MyExtra();
		myExtra.setAbc("abc");
		myExtra.setXyz("xyz");
		customer.setMyExtra(myExtra);
		CustomerExtraData ced = new CustomerExtraData();
		ced.setCustomer(customer);
		ced.setEsininAdi("Nil");
		ced.setTckn("29839238238");
		customer.setCed(ced);
		List<Account> accounts = new ArrayList<>();
		Account account = new Account();
		account.setCustomer(customer);
		account.setAccountName("account1");
		account.setAmount(200);
		accounts.add(account);

		Account account2 = new Account();
		account2.setCustomer(customer);
		account2.setAccountName("account2");
		account2.setAmount(100);
		accounts.add(account2);
		customer.setAccounts(accounts);
		return customer;
	}
	
}
