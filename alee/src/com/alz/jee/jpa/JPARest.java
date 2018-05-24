package com.alz.jee.jpa;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.alz.jee.common.Employee;
import com.alz.jee.common.Phone;

@Path("/jpa")
public class JPARest {
	
	@EJB
	private EmployeeDAO emDAO;
	
	@Path("/insert")
	@POST
	public String insertEmployee(Employee employee) {
		if (employee.getSalary() != null) {
			employee.getSalary().setEmployee(employee);
		}
		List<Phone> phones = employee.getPhones();
		if (phones != null) {
			for (Phone phone : phones) {
				phone.setEmployee(employee);
			}
		}
		emDAO.insertEmployeeToDB(employee);
		return "OK";
	}

	@Path("/update")
	@POST
	public String updateEmployee(Employee employee) {
		emDAO.updateEmployee(employee);
		return "OK";
	}

	@Path("/get/{emid}")
	@GET
	public Employee getEmployee(@PathParam("emid") long employeeId) {
		return emDAO.findEmployee(employeeId);
	}
	
	@Path("/remove/{emid}")
	@GET
	public String  removeEmployee(@PathParam("emid") long employeeId) {
		Employee findEmployee = emDAO.findEmployee(employeeId);
		if (findEmployee == null) {
			return "FAILED";
		}
		emDAO.removeEmployee(findEmployee);
		return "OK";
	}
	

}
