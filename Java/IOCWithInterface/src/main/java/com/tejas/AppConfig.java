package com.tejas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.model.Account;
import com.tejas.model.AccountImpl;

@Configuration
public class AppConfig {

	@Bean
	public Account savings() {
		Account acc = new AccountImpl(101, 10000, "SAVINGS"
				,new ConsoleLoggerImpl());
		return acc;
	}
	@Bean
	public Account current() {
		Account acc = new AccountImpl();
		acc.setBalance(45000);
		acc.setId(792);
		acc.setType("CURRENT");
		return acc;
	}

}
