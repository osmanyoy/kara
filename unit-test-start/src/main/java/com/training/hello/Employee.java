package com.training.hello;

public class Employee {
	private String name;
	private int age = 1;
	private int workTime = 1;

	public int calculate() {
		return this.age * this.workTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public int getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(final int workTime) {
		this.workTime = workTime;
	}

	@Override
	public String toString() {
		return "Employee [name=" + this.name + ", age=" + this.age + ", workTime=" + this.workTime + "]";
	}

}
