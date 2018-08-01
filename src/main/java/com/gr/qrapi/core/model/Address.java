package com.gr.qrapi.core.model;

import java.io.Serializable;

//@Entity
//@Table(name = "Address")
public class Address implements Serializable{
	
	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue
//	@Column(name = "id")
	private int id;

//	@Column(name = "street_address")
	private String streetAddress;

//	@Column(name = "city")
	private String city;

//	@Column(name = "state")
	private String state;

//	@Column(name = "country")
	private String country;

	public Address() {

	}

	public Address(String streetAddress, String city, String state, String country) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
