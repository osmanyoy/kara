package com.training.spring.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private long accoundId;
	private String accountName;
	private long amount;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Customer customer;
	
	public long getAccoundId() {
		return accoundId;
	}
	public void setAccoundId(long accoundId) {
		this.accoundId = accoundId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
