package com.tejas.model;

import com.tejas.logger.Logger;

public interface Book {
	String getBookName();
	float getPrice();
	Author getAuthor();
	
	void setBookName(String book);
	void setPrice(float price);
	void setAuthor(Author author);
	void setLogger(Logger logger);
}
