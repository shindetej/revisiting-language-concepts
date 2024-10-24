package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.logger.FileLoggerImpl;
import com.tejas.logger.Logger;
import com.tejas.model.Account;
import com.tejas.model.AccountImpl;
import com.tejas.model.Person;
import com.tejas.model.PersonImpl;

@Configuration
public class AppConfig {
	
	private final Logger logger;
	/*
	 * @Bean public Logger consoleLogger() { Logger logger = new
	 * ConsoleLoggerImpl(); return logger; }
	 */

	public  AppConfig(FileLoggerImpl logger) {
		this.logger = logger;
	}

	@Bean
	public Account savings() {
		Account acc = new AccountImpl(101, 10000, "SAVINGS", null);
		acc.setPerson(p1());
		return acc;
	}

	@Bean
	public Person p1() {
		return new PersonImpl("Suresh", "suresh@gmail.com", "9920112211");
	}

	@Bean
	public Account current() {
		Account acc = new AccountImpl();
//		acc.setLogger(fileLogger());
		acc.setLogger(this.logger);
		acc.setBalance(45000);
		acc.setId(792);
		acc.setType("CURRENT");
		acc.setPerson(p1());
		return acc;
	}

}
