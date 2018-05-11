package com.training.spring.kkb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xyz")
public class MyImpl1 implements IMyInter
{

	@Override
	public String execute() {
		return "Hello World 1";
	}

}
