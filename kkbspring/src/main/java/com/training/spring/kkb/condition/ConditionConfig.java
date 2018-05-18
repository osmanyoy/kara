package com.training.spring.kkb.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {
	
	
	@Bean
	@MyConditionAnno(key="live")
	public MyBean myBean1() {
		return new MyBean("1");
	}

	@Bean
	@MyConditionAnno(key="dev")
	public MyBean myBean2() {
		return new MyBean("2");
	}

}
