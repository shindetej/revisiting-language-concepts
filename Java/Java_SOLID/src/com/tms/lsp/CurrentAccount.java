package com.tms.lsp;

public class CurrentAccount implements WithdrawableAccount{
	@Override
	public void withdraw(Long amount) {
		System.out.println("In CurrentAccount withdraw()");
		
	}

	@Override
	public void deposit(Long amount) {
		System.out.println("In CurrentAccount deposit()");
	}

}
