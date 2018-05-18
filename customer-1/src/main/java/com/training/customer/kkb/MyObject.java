package com.training.customer.kkb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MyObject {
	
	@Id
	@GeneratedValue
	private long moId;
	private String name;
	private String surname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getMoId() {
		return moId;
	}
	public void setMoId(long moId) {
		this.moId = moId;
	}
	
	
	
}
