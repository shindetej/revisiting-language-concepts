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
public class AutowiringDemo implements CommandLineRunner {
	@Autowired
	ApplicationContext context;
	@Autowired
	Logger logger;
	
	public static void main(String[] args) {
		SpringApplication.run(AutowiringDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello SB");
//		Logger logger = (Logger) context.getBean("fileLogger");
		logger.log("In Main() after logger bean");
		Person p1 =  (Person) context.getBean("person1"); 

		Person p2 =  (Person) context.getBean("p2"); 
	
		Account current = (Account) context.getBean("current");
		Account saving = (Account) context.getBean("saving");
		saving.deposit(1000); // console logger called here as qualified bean in AccountImpl
		saving.deposit(5000);
		logger.log("current :"+current); // file logger called as primary default bean
		logger.log("saving :"+saving);
		logger.log("END");
		
	}

}
