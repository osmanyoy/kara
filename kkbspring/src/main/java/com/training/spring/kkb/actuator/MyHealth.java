package com.training.spring.kkb.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

	public static class Reason {
		private String msg;
		private int cause;

		public String getMsg() {
			return msg;
		}

		public Reason setMsg(String msg) {
			this.msg = msg;
			return this;
		}

		public int getCause() {
			return cause;
		}

		public Reason setCause(int cause) {
			this.cause = cause;
			return this;
		}

	}

	@Override
	public Health health() {
		return Health.down()
		             .withDetail("reason",
		                         new Reason().setMsg("Error test")
		                                     .setCause(100))
		             .build();
	}

}
