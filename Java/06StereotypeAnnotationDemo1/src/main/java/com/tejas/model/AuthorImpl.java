package com.tejas.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component	
public class AuthorImpl implements Author {
	String name;
	String mobile;
	String email;
	
	public AuthorImpl() {
		name = "test-author";
		mobile = "4567890";
		email = "email.com";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getMobile() {
		return this.mobile;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	@Override
	public void setMobile(String mobile) {
		// TODO Auto-generated method stub
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "AuthorImpl [name=" + name + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	@PostConstruct
	public void init1() {
		System.out.println("AuthorImpl Constructed");
	}
	
	
}
