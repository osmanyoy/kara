package com.training.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	
	@NotNull
	@Size(min=5)
	private String name;
	@XmlElement(nillable=true,required=true)
	private String sirname;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge( int age) {
		this.age = age;
	}
	public String getSirname() {
		return sirname;
	}
	public void setSirname( String sirname) {
		this.sirname = sirname;
	}
	
	
	
}
