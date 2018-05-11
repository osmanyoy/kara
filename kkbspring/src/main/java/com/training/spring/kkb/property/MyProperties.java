package com.training.spring.kkb.property;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="kkb")
@Validated
public class MyProperties {
	
	@NotNull
	@NotBlank
	@Size(min=4,max=25)
	private String server;
	@Max(value=2000,message="sjadjskad asdkjasdklj askdjsakd")
	@Min(1000)
	private int port;
	private String[] msgs;
	@Size(min=1,max=10)
	private List<String> strs;
	private Map<String, Integer> serverMap;
	private SubObject subObject;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String[] getMsgs() {
		return msgs;
	}
	public void setMsgs(String[] msgs) {
		this.msgs = msgs;
	}
	public List<String> getStrs() {
		return strs;
	}
	public void setStrs(List<String> strs) {
		this.strs = strs;
	}
	public Map<String, Integer> getServerMap() {
		return serverMap;
	}
	public void setServerMap(Map<String, Integer> serverMap) {
		this.serverMap = serverMap;
	}
	public SubObject getSubObject() {
		return subObject;
	}
	public void setSubObject(SubObject subObject) {
		this.subObject = subObject;
	}
	@Override
	public String toString() {
		return "MyProperties [server=" + server + ", port=" + port + ", msgs=" + Arrays.toString(msgs) + ", strs="
		        + strs + ", serverMap=" + serverMap + ", subObject=" + subObject + "]";
	}
	
	
	
}
