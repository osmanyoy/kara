package com.training.spring.kkb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.training.spring.kkb.property.MyProperties;

import d.e.f.MyOtherBean;

@Component
public class RunAfterStartup implements CommandLineRunner{

	@Autowired
	private KkbspringApplication app;
	
	@Autowired
	private MyOtherBean myother;
	
	@Autowired
	private MyProperties myConfig;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(app.getMyInter().execute());
		System.out.println(myother.hello());
		System.out.println(myConfig);
	}

}
