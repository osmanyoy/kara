package com.training.spring.kkb.appevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AppEventRunner implements CommandLineRunner{

	@Autowired
	private ApplicationEventPublisher aep;
	
	@Override
	public void run(String... args) throws Exception {
		MyEvent myEvent = new MyEvent();
		myEvent.setExtraData("Extra Data");
		myEvent.setTest(false);
		aep.publishEvent(myEvent);
	}

}
