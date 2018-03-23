package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {
	@Autowired
	private Callee callee;
	
	public void call() {
		String hello = callee.hello2("osman");
		System.out.println("hello response : " + hello);
	}
}
