package com.training.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("osman")
public class MyImpl1 implements IMyInt{

	private int count;
	
	@Override
	public String execute() {
		increase();
		return "Impl1";
	}
	
	private synchronized void increase() {
		count++;
		
	}

}
