package com.training.spring.appevent;

import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EvenListenerAuth {
	
	@EventListener
	public void handleEvent(AuditApplicationEvent applicationEvent) {
		System.out.println(applicationEvent.getAuditEvent());
	}
	
}
