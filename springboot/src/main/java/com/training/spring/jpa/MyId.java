package com.training.spring.jpa;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MyId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3812536003107698061L;
	
	private long id;
	private String ney;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNey() {
		return ney;
	}
	public void setNey(String ney) {
		this.ney = ney;
	}
	
	
}
