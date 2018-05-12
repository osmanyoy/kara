package com.training.spring.kkb.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
	Optional<List<Employee>> findByNameOrderBySurname(String name);

	List<Employee> findByNameAndSurnameOrderBySurname(String name,String surname);
	
	List<Employee> findByNameIn(List<String> name);
	
	@Query("select e from Employee e where e.name= :isim")
	List<Employee> employeeAl(@Param("isim") String name);

	@Query(value = "select * from employee where name = :isim",nativeQuery=true)
	List<Employee> employeeAl2(@Param("isim") String name);
	
	List<Employee> butunAl(@Param("isim") String name);
	
}
