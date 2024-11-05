package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.model.Book;

@SpringBootApplication
public class SetterAutowiringDemo implements CommandLineRunner {
	@Autowired
	ApplicationContext ctx ;
	public static void main(String[] args) {
		SpringApplication.run(SetterAutowiringDemo.class, args);
	}

	public void run(String...args){
		System.out.println("Hello SB");
		Book book = (Book)ctx.getBean("book");
//		book.setBookName("Unix : Concepts And Applications");
//		book.setPrice(400);
		System.out.println(book.getBookDetails());
	}
}
