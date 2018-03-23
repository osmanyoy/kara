package com.training.spring.aop;

public class Callee {
	
	public String hello(String str) {
		if (str.equals("abc")) {
			throw new IllegalArgumentException();
		}
		return "hello " + str;
	}
	
	@LogAt(extraData="test1")
	public String hello2(String str) {
		if (str.equals("abc")) {
			throw new IllegalArgumentException();
		}
		return "hello " + str;
	}
	
}
