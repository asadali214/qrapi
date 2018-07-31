package com.gr.qrapi.core.model;

import java.util.ArrayList;

public class Account {

	private int id;

	private String name;

	private String emailDomain;

	private String timeZoneCity;

	private ArrayList<Contact> contacts = new ArrayList<Contact>();

	private ArrayList<AlertProfile> alerts = new ArrayList<AlertProfile>();

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

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}
	

	public ArrayList<AlertProfile> getAlerts() {
		return alerts;
	}

	public void setAlerts(ArrayList<AlertProfile> alerts) {
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
