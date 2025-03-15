package com.glx.model;

import java.util.List;

public class Customer {
	String name;
	List<String> orders	;
	public Customer(String name, List<String> orders) {
		super();
		this.name = name;
		this.orders = orders;
	}
	
	public List<String> getOrders() {
		return orders;
	}
	

}
