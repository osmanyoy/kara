package com.training.spring.kkb.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/int")
public class IntRest {
	
	@GetMapping
	public String hello() {
		return "hello";
	}
}
