package com.training.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MyExtra {
	@Column(name="m_abc")
	private String abc;
	private String xyz;
	
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}
	public String getXyz() {
		return xyz;
	}
	public void setXyz(String xyz) {
		this.xyz = xyz;
	}
	
	
}
