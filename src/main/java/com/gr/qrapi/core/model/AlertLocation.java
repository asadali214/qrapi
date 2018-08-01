package com.gr.qrapi.core.model;

import java.io.Serializable;

//@Entity
//@Table(name = "AlertLocation")
public class AlertLocation implements Serializable{
	
	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue
//	@Column(name = "id")
	private int id;
	
//	@Column(name = "city")
	private String city;
	
//	@Column(name = "country")
	private String country;

	public AlertLocation() {
		
	}

	public AlertLocation(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	


}
