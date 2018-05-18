package com.training.spring.kkb.jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "MMMDDDD")
public class BaseObject {
	@Id
	@GeneratedValue
	private long baseId;
	
	private String data1;
	private String data2;
	private String data3;
	public long getBaseId() {
		return baseId;
	}
	public void setBaseId(long baseId) {
		this.baseId = baseId;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getData3() {
		return data3;
	}
	public void setData3(String data3) {
		this.data3 = data3;
	}

	
}
