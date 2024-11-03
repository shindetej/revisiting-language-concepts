package com.tejas.model;

public interface Author {
	void setRating(int rating);
	void setName(String name);
	void setEmail(String email);
	
	int getRating();
	String getName();
	String getEmail();

}
