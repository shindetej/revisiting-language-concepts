package com.tejas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tejas.model.Account;

@SpringBootApplication
public class DiDemo2Application implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DiDemo2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Spring Boot!!");
		
		System.out.println("-------- SAVING ACCOUNT ------");
		
		Account sacc = (Account) context.getBean("savings");
		System.out.println("Initial Balance : "+ sacc.getBalance());
		sacc.deposit(8000);
		sacc.withdraw(7000);
		System.out.println("Final Balance : "+ sacc.getBalance());
		
		System.out.println("-------- CURRENT ACCOUNT ------");
		Account currentAcc = (Account) context.getBean("current");
		System.out.println("Initial Balance : "+ currentAcc.getBalance());
		currentAcc.deposit(5500);
		currentAcc.withdraw(12300);
		System.out.println("Final Balance : "+ currentAcc.getBalance());
	}
	
	

}
