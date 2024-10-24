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
public class AnnotationDemo implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	
	public static void main(String[] args) {
		SpringApplication.run(AnnotationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Spring Boot!!");
		Logger logger =  (Logger) context.getBean("consoleLoggerImpl");
		System.out.println("-------- CURRENT ACCOUNT ------");
		Account currentAcc = (Account) context.getBean("current");
		currentAcc.setLogger(logger);
		System.out.println(currentAcc);
		System.out.println("Initial Balance : "+ currentAcc.getBalance());
		currentAcc.deposit(5500);
		currentAcc.withdraw(12300);
		System.out.println("Final Balance : "+ currentAcc.getBalance());
	}
	
	

}
