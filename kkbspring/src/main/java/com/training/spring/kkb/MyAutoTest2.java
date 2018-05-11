package com.training.spring.kkb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class MyAutoTest2 {

	private IMyInter inter;

	private MyBean bean;

	public MyAutoTest2(IMyInter inter,
	                   MyBean bean) {
		this.inter = inter;
		this.bean = bean;
		this.bean.setTest(1);
	}

}
