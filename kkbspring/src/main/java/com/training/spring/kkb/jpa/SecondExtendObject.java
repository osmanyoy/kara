package com.training.spring.kkb.jpa;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SECOND")
public class SecondExtendObject extends BaseObject{
	
	private String secondExtra;

	public String getSecondExtra() {
		return secondExtra;
	}

	public void setSecondExtra(String secondExtra) {
		this.secondExtra = secondExtra;
	}
	
	
}
