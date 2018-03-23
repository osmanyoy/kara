package com.training.spring.properties;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import com.training.spring.model.Person;

@ConfigurationProperties(prefix="kkb")
@Validated
public class KKBProperties {
	
	@NotNull
	private String deneme;
	
	@Size(min=2)
	private String test;
	private int port;
	
	private Person obj;
	
	private String[] strs;
	
	private List<String> strList;
	
	private Map<String, Integer> portMap;
	
	public String getDeneme() {
		return deneme;
	}
	public void setDeneme(String deneme) {
		this.deneme = deneme;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "KKBProperties [deneme=" + deneme + ", test=" + test + ", port=" + port + "]";
	}
	public Person getObj() {
		return obj;
	}
	public void setObj(Person obj) {
		this.obj = obj;
	}
	public String[] getStrs() {
		return strs;
	}
	public void setStrs(String[] strs) {
		this.strs = strs;
	}
	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	public Map<String, Integer> getPortMap() {
		return portMap;
	}
	public void setPortMap(Map<String, Integer> portMap) {
		this.portMap = portMap;
	}
	
	
	
}
