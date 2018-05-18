package com.training.spring.kkb.async;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
public class MyAsyncConfig {
	
	@Bean
	public MyAsyncObject myAsyncObject() {
		return new MyAsyncObject();
	}
	
//	@Bean
//	public ExecutorService executorService() {
//		new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//	}
	
	@Bean
	public Executor myExecutor() {
		return Executors.newFixedThreadPool(20);
	}
	
	@Scheduled(fixedDelay=10_000)
	public void sc() {
		System.out.println("Schedule");
	}
}
