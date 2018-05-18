package com.training.spring.kkb.aop;

public class Callee {
	
	@MyLog(logType=ELogType.DEBUG)
	public String hello(String name) {
		return "hello " + name;
	}
}
