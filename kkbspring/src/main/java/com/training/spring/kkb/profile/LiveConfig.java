package com.training.spring.kkb.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("live")
public class LiveConfig {

	@Bean
	public IProfileTest profileTest() {
		return new ProfileTest2();
	}
}
