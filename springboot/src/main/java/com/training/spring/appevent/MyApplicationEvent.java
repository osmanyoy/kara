package com.training.spring.appevent;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

	private String message;

	public MyApplicationEvent() {
		super(MyApplicationEvent.class);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
