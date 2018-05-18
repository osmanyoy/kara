package com.training.spring.kkb.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {
	
	@Autowired
	private Callee callee;
	
	public void execute() {
		System.out.println(callee.hello("osman"));
	}
	
}
