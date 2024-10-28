package com.tejas.model;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.logger.FileLoggerImpl;
import com.tejas.logger.Logger;

import jakarta.annotation.PostConstruct;

public class BookImpl implements Book {

	private String bookName;
	private Author author;
	private float price;
	private Logger logger;

	public BookImpl() {
		logger = new FileLoggerImpl();
		
	}

	public BookImpl(String bookName, Author author, float price) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.logger = new ConsoleLoggerImpl();
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public void setPrice(float price) {
		this.price = price;
		
	}

	@Override
	public String toString() {
		return "BookImpl [bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
	}

	@PostConstruct
	public void init() {
		logger.log("BookImpl Constructed");
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}


}
