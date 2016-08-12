package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component("supplier")

public class Supplier {
	@Id
	private String id;
	private String name;
	private String address;
	private String Email;
	private String Contactno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContactno() {
		return Contactno;
	}

	public void setContactno(String contactno) {
		Contactno = contactno;
	}

}
