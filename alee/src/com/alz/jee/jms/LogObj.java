package com.alz.jee.jms;

import java.io.Serializable;

public class LogObj implements Serializable{
		
	private static final long serialVersionUID = 2539409844640900319L;

	private int type;
	private String message;
	private int test;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

}
