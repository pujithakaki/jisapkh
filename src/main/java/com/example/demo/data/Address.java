package com.example.demo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



    @Entity
	@Table(name = "address")
	public class Address {
		
    	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;	
	@Column	
	private String street;
	@Column
	private String suite;
	@Column
	private String city;
	@Column
	private String zipcode;
	
	public Address() {
		super();
	}

	public Address(long id, String street, String suite, String city, String zipcode) {
		super();
		this.id = id;
		this.street = street;
		this.suite = suite;
		this.city = city;
		this.zipcode = zipcode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
	
		
}
