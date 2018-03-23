package com.training.spring;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TestConfig {
	
	@Bean
	public RestOperations rest(RestTemplateBuilder restTemplateBuilder) {
	    return restTemplateBuilder.basicAuthorization("osmanyay", "1234").build();
	
	}
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
}
