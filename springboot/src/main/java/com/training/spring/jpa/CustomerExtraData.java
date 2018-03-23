package com.training.spring.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerExtraData implements Serializable {
	@Id
	@GeneratedValue
	private long cedId;
	private String tckn;
	private String esininAdi;

	@JsonIgnore
	// @XmlTransient
	@OneToOne(fetch = FetchType.EAGER)
	private Customer customer;

	public long getCedId() {
		return cedId;
	}

	public void setCedId(long cedId) {
		this.cedId = cedId;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public String getEsininAdi() {
		return esininAdi;
	}

	public void setEsininAdi(String esininAdi) {
		this.esininAdi = esininAdi;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
