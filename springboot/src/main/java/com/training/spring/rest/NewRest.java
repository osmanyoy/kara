package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.IMyInt;
import com.training.spring.Naber;

@RestController
@RequestMapping("/new")
public class NewRest {
	
	@Autowired
	@Naber
	private IMyInt myInt;
	
	@RequestMapping("/run")
	public String runMe() {
		return myInt.execute();
	}
}
