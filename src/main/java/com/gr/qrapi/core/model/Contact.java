
package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {

	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private String gender;

	private String phoneNumber;

	private Boolean status;

	private int accountId;

	private List<Address> addresses;

	public Contact() {

	}
	
	public Contact(String firstName, String lastName, String emailAddress, String gender, String phoneNumber,
			Boolean status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	// All the Getters&Setters are below:

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
