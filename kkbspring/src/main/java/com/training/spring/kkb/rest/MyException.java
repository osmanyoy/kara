package com.training.spring.kkb.rest;

public class MyException extends Exception {
	private String msg;
	private int errorIndex;

	public MyException(String msg,
	                   int errorIndex) {
		super();
		this.msg = msg;
		this.errorIndex = errorIndex;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getErrorIndex() {
		return errorIndex;
	}

	public void setErrorIndex(int errorIndex) {
		this.errorIndex = errorIndex;
	}

}
