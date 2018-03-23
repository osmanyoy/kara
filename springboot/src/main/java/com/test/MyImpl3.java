package com.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.training.spring.IMyInt;

public class MyImpl3 implements IMyInt{

	private String str;
	
	@Override
	public String execute() {
		return "Impl2 " + str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
