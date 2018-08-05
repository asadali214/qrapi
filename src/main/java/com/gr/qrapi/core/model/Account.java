package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {

	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private String userName;

	private String password;

	private String emailDomain;

	private String timeZoneCity;

	//changed both to array list for testing
	private List<Contact> contacts;

	private List<AlertProfile> alerts;;

	public Account() {

	}

	// Constructor to directly set all the properties:
	public Account(String name, String emailDomain, String timeZoneCity, String username, String pass) {
		super();
		this.name = name;
		this.emailDomain = emailDomain;
		this.timeZoneCity = timeZoneCity;
		userName = username;
		password = pass;

	}

	// All the Getters&Setters are below:

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
