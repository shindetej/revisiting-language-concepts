package com.tejas.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("book")
public class BookImpl implements Book {
	private String bookName;
	//@Autowired
	private Author author; // Author is injected via setter
	private double price;

	@PostConstruct
	public void initPost() {
		System.out.println("Called BookImpl class @PostConstruct ");
	}

	public BookImpl() { 
		System.out.println("In BookImpl()");
	}

	
	@Autowired
    public BookImpl(Author author) {
		System.out.println("********* IN BookImpl() : Constructor based DI ");
        this.bookName = "Spring in Action";
        this.author = author;
        this.price = 29.99;
    }
	
	// @Autowired // SETTER
	public void setAuthor(Author author) {
		System.out.println("********* In BookImpl.setAuthor()  Setter based Autowiring   *********");
		this.author = author;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getBookDetails() {
		// TODO Auto-generated method stub
		return "Book Name : "+ this.bookName + "\nAuthor : "+ this.author.getName() + "\nPrice : "+this.price  ;
	}

}
