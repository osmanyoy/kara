package com.alz.jee.customer.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	private Long id;

	@NotNull
	@Size(min = 3, max = 25,message="yanlýþ giriþ 3 ile 25 arasýnda olsun")
	private String name;

	@NotNull
	@Size(min = 3, max = 50)
	private String surname;

	@NotNull
	@Size(min = 10, max = 12)
	@Pattern(regexp = "[0-9]+")
	private String phoneNumber;

	@Max(100)
	@Min(10)
	private int age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
