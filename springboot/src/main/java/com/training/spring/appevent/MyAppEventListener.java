package com.training.spring.appevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyAppEventListener implements ApplicationListener<MyApplicationEvent>{

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("Event message : " + event.getMessage());
		
	}

}
