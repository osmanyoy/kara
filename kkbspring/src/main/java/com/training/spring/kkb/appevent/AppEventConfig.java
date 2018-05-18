package com.training.spring.kkb.appevent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Configuration
public class AppEventConfig {
	
	@Bean
	public Executor myThreadPool() {
		return Executors.newFixedThreadPool(5);
	}
	
	
	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
		eventMulticaster.setTaskExecutor(myThreadPool());
		return eventMulticaster;
	}
	
}
