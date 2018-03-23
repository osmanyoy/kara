package com.training.spring.rest;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvisor {

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MyException.class)
	public ErrorObj handleMyException(MyException myException) {
		ErrorObj errorObj = new ErrorObj(myException.getMesaj(), myException.getNeden());
		return errorObj;
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public ErrorObj handleMyException2(ValidationException myException) {
		ErrorObj errorObj = new ErrorObj(myException.getMessage(),100);
		return errorObj;
	}

}
