package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.List;

//@Entity
//@Table(name = "Account")
public class Account implements Serializable{

	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue
//	@Column(name = "id")
	private int id;

//	@Column(name = "Name")
	private String name;

//	@Column(name = "Email_Domain")
	private String emailDomain;

//	@Column(name = "TimeZoneCity")
	private String timeZoneCity;

//	@OneToMany(mappedBy = "account")
	private List<Contact> contacts;
	
//	@OneToMany(mappedBy = "account")
	private List<AlertProfile> alerts;

	public Account() {

	}

	// Constructor to directly set all the properties:
	public Account(String name, String emailDomain, String timeZoneCity) {
		super();
		this.name = name;
		this.emailDomain = emailDomain;
		this.timeZoneCity = timeZoneCity;

	}

	// All the Getters&Setters are below:

	public int getId() {
		return id;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	

	public List<AlertProfile> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<AlertProfile> alerts) {
		this.alerts = alerts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public String getTimeZoneCity() {
		return timeZoneCity;
	}

	public void setTimeZoneCity(String timeZoneCity) {
		this.timeZoneCity = timeZoneCity;
	}

}
