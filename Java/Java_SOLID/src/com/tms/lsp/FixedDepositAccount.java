package com.tms.lsp;


// Older Super type of Account has withdraw() hence subtype not substitutable entirely with super class
public class FixedDepositAccount implements Account {

	@Override
	public void deposit(Long amount) {
		System.out.println("In FixedDepositAccount deposit()");		
	}

}
