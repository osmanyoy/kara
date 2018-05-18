package com.training.spring.kkb.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Bean
	public IProfileTest profileTest() {
		return new ProfileTest1();
	}
}
