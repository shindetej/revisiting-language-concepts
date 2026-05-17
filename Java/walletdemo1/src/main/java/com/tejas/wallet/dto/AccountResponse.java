package com.tejas.wallet.dto;

import java.math.BigDecimal;

public class AccountResponse {

	private Long id;
	private String accountHolder;
	private BigDecimal balance;

	public AccountResponse(Long id, String accountHolder, BigDecimal balance) {
		this.id = id;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public BigDecimal getBalance() {
		return balance;
	}
}