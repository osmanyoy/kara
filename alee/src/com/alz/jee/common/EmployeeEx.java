package com.alz.jee.common;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Exp1")
public class EmployeeEx extends Employee{
	
	private String empDescription;
	private String xyz;
	
	public String getEmpDescription() {
		return empDescription;
	}
	public void setEmpDescription(String empDescription) {
		this.empDescription = empDescription;
	}
	public String getXyz() {
		return xyz;
	}
	public void setXyz(String xyz) {
		this.xyz = xyz;
	}
	
	
	
}
