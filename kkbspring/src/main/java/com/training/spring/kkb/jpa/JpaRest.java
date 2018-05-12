package com.training.spring.kkb.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
public class JpaRest {
	
	@Autowired
	private EmployeeDAO empDAO;
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		empDAO.save(employee);
		return employee;
	}
}
