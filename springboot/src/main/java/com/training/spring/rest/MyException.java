package com.training.spring.rest;

public class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5570060525415874830L;
	
	private String mesaj;
	private int neden;
	
	
	public MyException(String mesaj, int neden) {
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
