package com.training.spring.kkb.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inh")
public class JpaInheriRest {
	
	@Autowired
	private BaseDAO baseDAO;
	
	@PostMapping("/first")
	public String createEmployee(@RequestBody FirstExtendObject firstExtendObject) {
		baseDAO.save(firstExtendObject);
		return "OK";
	}

	@PostMapping("/second")
	public String createEmployee(@RequestBody SecondExtendObject secondExtendObject) {
		baseDAO.save(secondExtendObject);
		return "OK";
	}

}
