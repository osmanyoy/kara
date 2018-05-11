package com.training.spring.kkb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.kkb.IMyInter;
import com.training.spring.kkb.MyQAnno;

@RestController
@RequestMapping("/r")
public class MyRest {

	@Autowired
	private  IMyInter myImpl1;
	
	@Autowired
	@MyQAnno
	private IMyInter inter;
	
	@Autowired
	@Qualifier("ahmet")
	private IMyInter inter3;

	@RequestMapping("/m1")
	public String m1() {
		return myImpl1.execute();
	}
	
	@RequestMapping("/m2")
	public String m2() {
		return inter.execute();
	}

	@RequestMapping("/m3")
	public String m3() {
		return inter3.execute();
	}

}
