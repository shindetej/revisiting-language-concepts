package com.tms.lsp;

public class SavingsAccount implements WithdrawableAccount{

	@Override
	public void withdraw(Long amount) {
		System.out.println("In SavingsAccount withdraw()");
		
	}

	@Override
	public void deposit(Long amount) {
		System.out.println("In SavingsAccount deposit()");
	}

}
