package com.training.spring.rest;

public class ErrorObj {
	private String mesaj;
	private int neden;
	
	
	public ErrorObj(String mesaj, int neden) {
		super();
		this.mesaj = mesaj;
		this.neden = neden;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	public int getNeden() {
		return neden;
	}
	public void setNeden(int neden) {
		this.neden = neden;
	}
	
	
}
