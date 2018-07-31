package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "AlertProfile")
public class AlertProfile implements Serializable{
	
	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@ManyToOne
	private Account account;

	@OneToMany(mappedBy = "alert")
	private List<AlertLocation> locations;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<AlertLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<AlertLocation> locations) {
		this.locations = locations;
	}

	
}
