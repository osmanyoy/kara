package com.training.spring.kkb.appevent;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{

	private static final long serialVersionUID = 7644770326904592668L;

	private String extraData;
	
	private boolean test;
	
	public MyEvent() {
		super(MyEvent.class);
	}

	public String getExtraData() {
		return extraData;
	}

	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

}
