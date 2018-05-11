package com.training.spring.kkb.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestTraining {
	
	@RequestMapping(path="/hello1",method=RequestMethod.GET)
	public String hello1(String name) {
		
	}
	
}
