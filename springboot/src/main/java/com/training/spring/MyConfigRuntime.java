package com.training.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"run","dev"})
public class MyConfigRuntime {
	
	@Bean
	@Naber
	public IMyInt developmentInterface() {
		return new MyImpl2();
	}
	
}
