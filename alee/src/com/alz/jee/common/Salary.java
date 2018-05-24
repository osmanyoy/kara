package com.alz.jee.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Salary {
	@Id
	@GeneratedValue
	private long salId;
	private int salary;
	private String description;
	
	@OneToOne
	@XmlTransient
	private Employee employee;
	
	public long getSalId() {
		return salId;
	}
	public void setSalId(long salId) {
		this.salId = salId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
