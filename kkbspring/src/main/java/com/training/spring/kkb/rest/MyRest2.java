package com.training.spring.kkb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.training.spring.kkb.IMyInter;
import com.training.spring.kkb.MyQAnno;

@RestController
@RequestMapping("/r2")
@RequestScope
public class MyRest2 {

	@Autowired
	@Qualifier("ali")
	private  IMyInter myImpl1;
	
	@RequestMapping("/m1")
	public String m1() {
		return myImpl1.execute();
	}
	

}
