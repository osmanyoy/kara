package com.training.spring.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator{

	@Override
	public Health health() {
		return Health.down().build();
	}

}
