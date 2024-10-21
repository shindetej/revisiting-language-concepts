package com.tejas.model;

public interface Account {
	void setId(int id);
	int getId();
	
	void setType(String type);
	String getType();
	
	void setBalance(double amount);
	double getBalance();
	
	void deposit(double amount);
	void withdraw(double amount);
	
}
