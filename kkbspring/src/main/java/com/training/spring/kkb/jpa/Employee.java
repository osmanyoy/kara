package com.training.spring.kkb.jpa;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.cache.CacheType;

@NamedQueries({
	@NamedQuery(name="Employee.butunAl",query="select e from Employee e where e.name= :isim")
	
})
@Entity
@Table(name="Empl",indexes= {@Index(columnList="isim,surname")})
@SecondaryTable(name = "extra")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empId;
	
	@Column(name="isim",length=50,nullable=false)
	private String name;
	private String surname;
	
	@Column(table="extra")
	private String extraData;
	
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Address address;
	
	@Convert(converter=XyzConverter.class)
	private Xyz xyz;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="employee")
	private List<Account> accounts;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="username",column=@Column(name="test"))
	})
	private EMployeeCredential credential;
	
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
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public EMployeeCredential getCredential() {
		return credential;
	}
	public void setCredential(EMployeeCredential credential) {
		this.credential = credential;
	}
	public String getExtraData() {
		return extraData;
	}
	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
