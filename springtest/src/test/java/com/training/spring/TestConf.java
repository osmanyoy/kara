package com.training.spring;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConf {
	
	@Bean
	public TestBean tb() {
		return new TestBean();
	}
	
	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();
	}
}
