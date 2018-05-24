package com.alz.jee.jpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.alz.jee.common.Employee;

@Stateless
@LocalBean
public class EmployeeDAO {

	@PersistenceContext(unitName = "alee")
	private EntityManager em;

	public EmployeeDAO() {
	}

	public boolean insertEmployeeToDB(Employee employee) {
		em.persist(employee);
		return true;
	}

	public boolean updateEmployee(Employee employee) {
		Employee mergedEmployee = em.merge(employee);
		return true;
	}
	
	public boolean removeEmployee(Employee employee) {
		if (!em.contains(employee)) {
			Employee mergedEmployee = em.merge(employee);
			em.remove(mergedEmployee);
		} else {
			em.remove(employee);
		}
		return true;
	}
	
	public Employee findEmployee(long empId) {
		return em.find(Employee.class, empId);
	}

}
