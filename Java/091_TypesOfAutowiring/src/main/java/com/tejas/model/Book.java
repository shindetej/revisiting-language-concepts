package com.tejas.model;

public interface Book {
	
	void setBookName(String bookName);
	void setAuthor(Author author);
	void setPrice(double price);

	String getBookName();
	double getPrice();
	Author getAuthor();
	String getBookDetails();
}
