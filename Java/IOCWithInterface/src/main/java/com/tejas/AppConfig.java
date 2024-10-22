package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.logger.FileLoggerImpl;
import com.tejas.logger.Logger;
import com.tejas.model.Account;
import com.tejas.model.AccountImpl;

@Configuration
public class AppConfig {

	@Bean
	public Logger consoleLogger() {
		Logger logger = new ConsoleLoggerImpl();
		return logger;
	}
	
	@Bean
	public Logger fileLogger() {
		Logger logger = new FileLoggerImpl();
		return logger;
	}
	
	
	@Bean
	public Account savings() {
		Account acc = new AccountImpl(101, 10000, "SAVINGS"
				,consoleLogger());
		return acc;
	}
	
	@Bean
	public Account current() {
		Account acc = new AccountImpl();
		acc.setLogger(fileLogger());
		acc.setBalance(45000);
		acc.setId(792);
		acc.setType("CURRENT");
		
		return acc;
	}

}
