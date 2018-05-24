package com.alz.jee.customer.rest;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accId;
	
	private String accountType;
	
	private int amount;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@XmlTransient
	private Customer customer;

	public long getAccId() {
		return accId;
	}

	public void setAccId(long accId) {
		this.accId = accId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
