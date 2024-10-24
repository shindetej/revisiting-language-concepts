package com.tejas.model;

public class PersonImpl implements Person {

	private String name;
	private String email;
	private String mobile;
	
	public PersonImpl() {
	}

	public PersonImpl(String name, String email, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public void setName(String name) {
		this.name  =  name;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return "PersonImpl [name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}

	
	
}
