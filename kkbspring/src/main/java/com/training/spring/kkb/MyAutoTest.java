package com.training.spring.kkb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class MyAutoTest {
	
	@Autowired
	@Qualifier("veli")
	private  IMyInter inter;
	
	@Autowired
	private MyBean bean;
	
	public MyAutoTest() {
	}

	@PostConstruct
	public void init() {
		bean.setTest(1);
	}
	
}
