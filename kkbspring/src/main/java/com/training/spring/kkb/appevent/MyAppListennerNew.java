package com.training.spring.kkb.appevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyAppListennerNew {

	@EventListener(condition="#myEvent.test")
	public void listen(MyEvent myEvent) {
		System.out.println("New Event Listener : " + myEvent.getExtraData());
	}
	
}
