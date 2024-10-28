package com.tejas.model;

import com.tejas.logger.Logger;

public interface Account {
	void setId(int id);
	int getId();
	
	void setType(String type);
	String getType();
	
	void setBalance(double amount);
	double getBalance();
	
	void setPerson(Person person);
	Person getPerson();
	
	void setLogger(Logger logger); // set logger added
	
	void deposit(double amount);
	void withdraw(double amount);
	
}
