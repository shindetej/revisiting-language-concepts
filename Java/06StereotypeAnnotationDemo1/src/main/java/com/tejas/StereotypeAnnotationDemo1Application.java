/*
 * This project showcases use of @Component (how we can create beans without explicitly writing in App config file created using @Configuration
 * how to change bean name in @Componet("here")
 * */

package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.logger.Logger;
import com.tejas.model.Author;
import com.tejas.model.Book;

@SpringBootApplication
public class StereotypeAnnotationDemo1Application implements CommandLineRunner{
	@Autowired
	public ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(StereotypeAnnotationDemo1Application.class, args);
	}
	
	@Override
	public void run(String... args) {
		
		System.out.println("Hello, Test starter project");
		
		Author author = (Author) context.getBean("authorImpl");
		
		Logger logger = (Logger) context.getBean("fileLogger");
		
		Book  b1 = (Book) context.getBean("b1");
		
		b1.setAuthor(author);
		System.out.println(b1);
	}

}
