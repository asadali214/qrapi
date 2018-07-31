package com.gr.qrapi.core.model;

import java.util.ArrayList;
import java.util.Collection;

public class AlertProfile {

	private int id;

	private Account account;

	private Collection<AlertLocation> locations = new ArrayList<AlertLocation>();

	public AlertProfile() {

	}

	public AlertProfile(int id, Account account) {
		super();
		this.id = id;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Collection<AlertLocation> getLocations() {
		return locations;
	}

	public void setLocations(Collection<AlertLocation> locations) {
		this.locations = locations;
	}

	
}
