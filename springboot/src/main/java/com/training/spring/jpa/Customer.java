package com.training.spring.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@NamedQueries({ @NamedQuery(query = "select c from Customer c where c.name = :isim", name = "Customer.isimdenCoz") })
@NamedNativeQueries({
	@NamedNativeQuery(query="select * from person where isim = :isim",name="myTestNativeCustomer")
	
})

@Entity
@Table(name = "person", indexes = { @Index(columnList = "isim", unique = false) })
@SecondaryTables({ @SecondaryTable(name = "secondperson"), @SecondaryTable(name = "thirdperson")

})
public class Customer {

	// @EmbeddedId
	// private MyId myId;

	@Id
	@GeneratedValue
	private long customerId;

	@Size(max = 10)
	@Column(name = "isim", length = 10, nullable = false)
	private String name;
	
	@Convert(converter=AdresConvert.class)
	private Adres address;

	private String customerMiddleName;

	private String surname;
	private int age;

	@Column(table = "secondperson")
	private String extra1;

	@Column(table = "secondperson")
	private String extra2;

	@Column(table = "thirdperson")
	private String other1;

	@Column(table = "thirdperson")
	private String other2;

	@Embedded
	@AttributeOverride(column = @Column(name = "test_abc"), name = "abc")
	private MyExtra myExtra;

	@Enumerated(EnumType.STRING)
	private EMyEnum myEnum;

	@Temporal(TemporalType.DATE)
	private Date myDate;

	@Transient
	private String temp;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
	        CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "cedJoin")
	private CustomerExtraData ced;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accounts;

	@PrePersist
	@PreUpdate
	@PreRemove
	public void beforeWrite() {

	}

	@PostPersist
	@PostUpdate
	@PostRemove
	@PostLoad
	public void afterWrite() {

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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public MyExtra getMyExtra() {
		return myExtra;
	}

	public void setMyExtra(MyExtra myExtra) {
		this.myExtra = myExtra;
	}

	public String getCustomerMiddleName() {
		return customerMiddleName;
	}

	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}

	public EMyEnum getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(EMyEnum myEnum) {
		this.myEnum = myEnum;
	}

	public Date getMyDate() {
		return myDate;
	}

	public void setMyDate(Date myDate) {
		this.myDate = myDate;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public CustomerExtraData getCed() {
		return ced;
	}

	public void setCed(CustomerExtraData ced) {
		this.ced = ced;
	}

}
