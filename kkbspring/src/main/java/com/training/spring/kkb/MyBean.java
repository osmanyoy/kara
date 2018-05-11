package com.training.spring.kkb;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
	
	private int test;
	
	
	private ApplicationContext applicationContext;
	
	public int getIndex() {
		String property = getApplicationContext().getEnvironment().getProperty("a.b.c", "1");
		return Integer.parseInt(property);
	}
	
	public int getIndex2() {
		Random random = new Random();
		return random.nextInt(4);
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	
}
