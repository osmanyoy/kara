package com.alz.jee.jpa;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.alz.jee.common.Employee;

@Stateless
@LocalBean
public class EmployeeDAO {

	@PersistenceContext(unitName = "alee")
	private EntityManager em;

	public EmployeeDAO() {
	}

	public List<Employee> getEmployeesByName(String name) {
		TypedQuery<Employee> createQuery = em.createQuery("select e from Employee e where e.name= :isim",
		                                                  Employee.class);
		createQuery.setParameter("isim", name);
		List<Employee> resultList = createQuery.getResultList();
		return resultList;
	}

	public List<Employee> getEmployeesByName2(String name) {
		Query createNativeQuery = em.createNativeQuery("select * from calisan where isim = :isim",
		                                                  Employee.class);
		createNativeQuery.setParameter("isim", name);
		List<Employee> resultList = createNativeQuery.getResultList();
		return resultList;
	}

	public List<Employee> getEmployeesByName3(String name) {
		TypedQuery<Employee> createNamedQuery = em.createNamedQuery("get_by_name",
		                                                  Employee.class);
		createNamedQuery.setParameter("isim", name);
		List<Employee> resultList = createNamedQuery.getResultList();
		return resultList;
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
		return em.find(Employee.class,
		               empId);
	}

}
