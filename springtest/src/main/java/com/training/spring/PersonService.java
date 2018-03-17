package com.training.spring;

public class PersonService {
	
	public String testMe(int age) {
		switch (age) {
		case 10:
			return "kkk";
		case 20:
			return "ccc";
		case 30:
			return "vvv";
		case 40:
			return "ddd";
		default:
			return "ddd";
		}
	}
	
}
