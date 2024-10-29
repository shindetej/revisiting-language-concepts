package com.tejas;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.logger.FileLoggerImpl;
import com.tejas.logger.Logger;
import com.tejas.model.Account;
import com.tejas.model.AccountImpl;
import com.tejas.model.Person;
import com.tejas.model.PersonImpl;

@PropertySource({ "classpath:demo.properties" })
@Configuration
public class AppConfig {
	
	
	/*
	 * @Bean public Logger consoleLogger() { Logger logger = new
	 * ConsoleLoggerImpl(); return logger; }
	 */

	

	@ConfigurationProperties(prefix = "p1")
	@Bean
	public Person person1() {
		return new PersonImpl();
	}

	@ConfigurationProperties(prefix = "p2")
	@Bean
	public Person p2() {
		return new PersonImpl();
	} 

	@ConfigurationProperties(prefix = "a1")
	@Bean
	public Account current() {
		return new AccountImpl();
	}
	
	@ConfigurationProperties(prefix = "a2")
	@Bean
	public Account saving() {
		return new AccountImpl();
	}

}
