package org.example.struts2hibernate.model;

import java.util.Date;

public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7698874158913289131L;
	private Long customerId;
	private String name;
	private String address;
	private Date createdDate;

	public Customer() {
	}

	public Customer(String name, String address, Date createdDate) {
		this.name = name;
		this.address = address;
		this.createdDate = createdDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
