package com.gr.qrapi.core.model;

public class AlertLocation {
	private int id;
	
	private String city;
	
	private String country;
	
	private AlertProfile alert;
	

	public AlertLocation() {
		
	}

	public AlertLocation(int id, String city, String country, AlertProfile alert) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.alert = alert;
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

	public AlertProfile getAlert() {
		return alert;
	}

	public void setAlert(AlertProfile alert) {
		this.alert = alert;
	}
	
	


}
