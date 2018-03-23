package com.training.spring.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class AsyncConf {
	
	@Bean
	public Executor executor() {
		return Executors.newFixedThreadPool(10);
	}
	
	@Bean
	public ConcurrentTest concurrentTest() {
		return new ConcurrentTest();
	}
	
	@Scheduled(initialDelay=2000, fixedDelay=5000)
	public void runme() {
		System.out.println("schedule");
	}
	
}
