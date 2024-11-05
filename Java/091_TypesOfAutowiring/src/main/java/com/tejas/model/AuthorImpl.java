package com.tejas.model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AuthorImpl implements Author {
	private String name;
	private String email;
	private int rating;
	
	@PostConstruct
	public void initPost() {
		System.out.println("Called AuthorImpl class @PostConstruct ");
	}
	
	public AuthorImpl() {
		this.name = "Thomas vitale";
		this.email = "tvitale@unix.com";
		this.rating = 4;
		System.out.println("In AuthorImpl()");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "AuthorImpl [name=" + name + ", email=" + email + ", rating=" + rating + "]";
	}

	

}
