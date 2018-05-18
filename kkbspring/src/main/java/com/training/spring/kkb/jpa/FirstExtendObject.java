package com.training.spring.kkb.jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FIRST")
public class FirstExtendObject extends BaseObject{
	
	private String firstExtra;

	public String getFirstExtra() {
		return firstExtra;
	}

	public void setFirstExtra(String firstExtra) {
		this.firstExtra = firstExtra;
	}
	
	
}
