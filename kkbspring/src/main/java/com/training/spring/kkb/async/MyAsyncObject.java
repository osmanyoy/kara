package com.training.spring.kkb.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;


public class MyAsyncObject {

	@Async("myExecutor")
	public ListenableFuture<String> hello(){
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
		}
		return AsyncResult.forValue("hello");
	}
	
}
