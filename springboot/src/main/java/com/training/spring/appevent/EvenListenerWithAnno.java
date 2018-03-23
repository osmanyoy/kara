package com.training.spring.appevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EvenListenerWithAnno {
	
	@EventListener
	public void handleEvent(MyApplicationEvent applicationEvent) {
		System.out.println("applicationEvent : " + applicationEvent.getMessage());
	}
	
}
