package com.tms.lsp;

public interface Account {
	void deposit(Long amount);
	/*Because all accounts do not support withdrawals, 
	 * we moved the withdraw method from the Account class to a new abstract subclass WithdrawableAccount.
	 */
	// void withdraw(Long amount); 
}
