package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.logger.Logger;
import com.tejas.model.Account;
import com.tejas.model.Person;

@SpringBootApplication
public class SpELFDemo implements CommandLineRunner {
	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(SpELFDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello SB");
		Logger logger = (Logger) context.getBean("fileLogger");
		logger.log("In Main() after logger bean");
		Person p1 =  (Person) context.getBean("person1"); 

		Person p2 =  (Person) context.getBean("p2"); 
	
		Account current = (Account) context.getBean("current");
		Account saving = (Account) context.getBean("saving");
		logger.log("current :"+current);
		logger.log("saving :"+saving);
		logger.log("END");
		
	}

}
