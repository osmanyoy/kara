package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class Runner {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);

		// SpringbootApplication application =
		// applicationContext.getBean(SpringbootApplication.class);
		//
		// System.out.println(application.myObject);
	}

}
