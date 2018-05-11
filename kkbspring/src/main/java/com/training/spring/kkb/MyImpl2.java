package com.training.spring.kkb;

import org.springframework.stereotype.Component;

@Component
public class MyImpl2 implements IMyInter
{

	@Override
	public String execute() {
		return "Hello World 2";
	}

}
