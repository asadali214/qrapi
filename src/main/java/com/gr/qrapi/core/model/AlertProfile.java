package com.gr.qrapi.core.model;

import java.io.Serializable;
import java.util.List;


//@Entity
//@Table(name = "AlertProfile")
public class AlertProfile implements Serializable{
	
	/*
	 * default version
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue
//	@Column(name = "id")
	private int id;
	
//	@Column(name = "name")
	private String name;


//	@OneToMany(mappedBy = "alert")
	private List<AlertLocation> locations;

	public AlertProfile() {

	}

	public AlertProfile(String name) {
		super();
		this.name=name;
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

	public List<AlertLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<AlertLocation> locations) {
		this.locations = locations;
	}

	
}
