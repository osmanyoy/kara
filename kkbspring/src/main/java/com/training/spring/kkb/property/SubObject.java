package com.training.spring.kkb.property;

public class SubObject {
	private String xyz;
	private int prq;
	
	public String getXyz() {
		return xyz;
	}
	public void setXyz(String xyz) {
		this.xyz = xyz;
	}
	public int getPrq() {
		return prq;
	}
	public void setPrq(int prq) {
		this.prq = prq;
	}
	@Override
	public String toString() {
		return "SubObject [xyz=" + xyz + ", prq=" + prq + "]";
	}
	
	
	
}
