package com.training.spring.kkb.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyAdvisor {
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex) {
		if (ex instanceof MyException) {
			MyException me = (MyException) ex;
			return "Error oluştu : " + me.getMsg() + " index : " + me.getErrorIndex();
		} else if (ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
			return "Error oluştu : " + manve.getMessage() + " index : " + 500;
		}
		return "Error oluştu";
	}

}
