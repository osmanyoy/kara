package com.training.spring.appevent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class EventConfig {
	
	@Bean
	public Executor eventPool() {
		return Executors.newFixedThreadPool(5);
	}
	
//	@Bean
//	@Qualifier("myMulti")
//	public ApplicationEventMulticaster createAem() {
//		SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
//		applicationEventMulticaster.setTaskExecutor(eventPool());
//		return applicationEventMulticaster;
//	}

	@Autowired
	public void multicasterConfig(ApplicationEventMulticaster eventMulticaster) {
		SimpleApplicationEventMulticaster applicationEventMulticaster = (SimpleApplicationEventMulticaster) eventMulticaster;
		applicationEventMulticaster.setTaskExecutor(eventPool());
	}
	
	
}





