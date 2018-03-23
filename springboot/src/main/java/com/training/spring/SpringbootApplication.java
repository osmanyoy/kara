package com.training.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @SpringBootApplication(scanBasePackages= {"com.test","com.training.spring"})

@SpringBootApplication
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringbootApplication implements ApplicationRunner {

	@Autowired
	private MyObject myObject;

	public SpringbootApplication() {
	}
	
	@PostConstruct
	public void init() {
		System.out.println(myObject.getStr());
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(myObject);
	}
}
