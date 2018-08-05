package com.gr.qrapi.core.model;

import java.io.Serializable;

public class AlertLocation implements Serializable{
	
	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String city;
	
	private String country;
	
	private int alertId;

	public AlertLocation() {
		
	}

	public AlertLocation(String city, String country) {
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

	public int getAlertId() {
		return alertId;
	}

	public void setAlertId(int alertId) {
		this.alertId = alertId;
	}
	
	
	


}
