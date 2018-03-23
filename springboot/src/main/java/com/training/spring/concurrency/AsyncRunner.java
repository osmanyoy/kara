package com.training.spring.concurrency;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class AsyncRunner implements CommandLineRunner{
	
	@Autowired
	private ConcurrentTest ct;
	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("start");
//		boolean process3_4 = false;
//		CompletableFuture<String> testAsync2 = ct.testAsync2("osman");
//		System.out.println("process1");
//		System.out.println("process2");
//		
//		if (!testAsync2.isDone()) {
//			process3_4 = true;
//			System.out.println("process3");
//			System.out.println("process4");
//		}
//		String string = testAsync2.get();
//		System.out.println("End : " + string);
//		if (!process3_4) {
//			System.out.println("process3");
//			System.out.println("process4");
//		}
//	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("start");
		boolean process3_4 = false;
		ListenableFuture<String> testAsync2 = ct.testAsync("osman");
		testAsync2.addCallback(new ListenableFutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				System.out.println("Result : " + result);
			}

			@Override
			public void onFailure(Throwable ex) {
				System.err.println("Failure : " + ex.getMessage());
			}
		});
		System.out.println("process1");
		System.out.println("process2");
		
		if (!testAsync2.isDone()) {
			process3_4 = true;
			System.out.println("process3");
			System.out.println("process4");
		}
		String string = testAsync2.get();
		System.out.println("End : " + string);
		if (!process3_4) {
			System.out.println("process3");
			System.out.println("process4");
		}
	}

}
