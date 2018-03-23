package com.training.spring.concurrency;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;

public class ConcurrentTest {
	
	@Async("executor")
	public ListenableFuture<String> testAsync(String str) {
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new AsyncResult<>("test");
	}
	
	@Async("executor")
	public CompletableFuture<String> testAsync2(String str) {
		try {
			Thread.sleep(1_000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("test1");
	}
}
