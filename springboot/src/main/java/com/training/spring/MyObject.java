package com.training.spring;

import org.springframework.stereotype.Component;

@Component
public class MyObject {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
