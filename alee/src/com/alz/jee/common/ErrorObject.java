package com.alz.jee.common;

public class ErrorObject {
	private String errorMessage;
	private int errorCause;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorObject setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public int getErrorCause() {
		return errorCause;
	}
	public ErrorObject setErrorCause(int errorCause) {
		this.errorCause = errorCause;
		return this;
	}
	
	
}
