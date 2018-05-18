package com.training.spring.kkb.async;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class MyCLIRunner implements CommandLineRunner{

	@Autowired
	private MyAsyncObject mao;
	
	@Override
	public void run(String... args) throws Exception {
		ListenableFuture<String> hello = (ListenableFuture<String>)mao.hello();
		hello.addCallback(new ListenableFutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				System.out.println("result : " + result);
			}
			
			@Override
			public void onFailure(Throwable ex) {
				
			}
		});
		System.out.println("Working......");
		String string = hello.get();
		System.out.println(string);
	}

}
