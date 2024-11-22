package com.tms.lsp;

public class LSPDemo {
	public static void main(String[] args) {
		
		WithdrawableAccount savings = new SavingsAccount();
		WithdrawableAccount current = new CurrentAccount();
		Account fd = new FixedDepositAccount();
		
		savings.deposit(10L);
		current.deposit(10L);
		fd.deposit(10L);
		current.withdraw(6L);
		savings.withdraw(6L);
	}
}
