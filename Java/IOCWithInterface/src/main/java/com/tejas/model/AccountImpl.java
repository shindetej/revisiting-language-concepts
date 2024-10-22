package com.tejas.model;

import org.springframework.context.annotation.Configuration;

import com.tejas.logger.ConsoleLoggerImpl;
import com.tejas.logger.FileLoggerImpl;
import com.tejas.logger.Logger;

public class AccountImpl implements Account {
	private int id;
	private double balance;
	private String type;
	private Logger logger;

	public AccountImpl(int id, double balance, 
			String type, Logger logger) {
		
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.logger = logger;
		logger.log("IN AccountImpl(int , double , String , Logger ) : CONSRTUCTOR BASED DI");
	}
	
	public AccountImpl() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
	
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	@Override
	public void deposit(double amount) {
		this.balance += amount;
		logger.log(amount + " deposited to account  " + this.getId() + ":\t  Total balance= " + this.balance);
	}

	@Override
	public void withdraw(double amount) {
		this.balance -= amount;
		logger.log(amount + " withdrawn to account  " + this.getId() + ":\t  Total balance= " + this.balance);
	}

}
