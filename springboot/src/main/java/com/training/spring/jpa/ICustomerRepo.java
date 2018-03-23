package com.training.spring.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.concurrent.ListenableFuture;

import java.lang.String;
import com.training.spring.jpa.Customer;
import java.util.List;

@EnableAsync
public interface ICustomerRepo extends CrudRepository<Customer, Long>{
	List<Customer> findBySurnameAndAgeOrderByName(String surname,int age);
	
	List<Customer> findBySurnameIn(List<String> names);

	@Async
	ListenableFuture<List<Customer>> getBySurnameIn(List<String> names);

	@Query("select c from Customer c where c.name = :isim")
	List<Customer> findCustomTest(@Param("isim") String name );
	
	@Query(value="select * from person where isim = :isim",nativeQuery=true)
	List<Customer> findCustomNativeTest(@Param("isim") String name );

	List<Customer> isimdenCoz(@Param("isim") String name);
	
	@Query("select c from Customer c JOIN FETCH c.ced JOIN FETCH c.accounts where c.name = :isim")
	List<Customer> findCustomTestEagerly(@Param("isim") String name );
	
	
	
}
