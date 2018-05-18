package com.training.spring.kkb.condition;

public class MyBean {
	
	private String str;

	public MyBean(String str) {
		this.str = str;
	}
	
	public String runMe() {
		return str;
	}
}
