package com.training.spring.kkb;

import org.springframework.stereotype.Component;

@Component
@MyQAnno
public class MyImpl3 implements IMyInter
{

	@Override
	public String execute() {
		return "Hello World 3";
	}

}
