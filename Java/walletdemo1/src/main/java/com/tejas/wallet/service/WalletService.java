package com.tejas.wallet.service;

import com.tejas.wallet.model.Account;
import com.tejas.wallet.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class WalletService {

	private final AccountRepository repository;

	public WalletService(AccountRepository repository) {
		this.repository = repository;
	}

	
	public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {

		Account sender = repository.findById(fromAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Sender account not found"));

		Account receiver = repository.findById(toAccountId)
				.orElseThrow(() -> new IllegalArgumentException("Receiver account not found"));

		updateAccountBalances(sender,receiver,amount);

		
	}
	

	public void updateAccountBalances(Account sender, Account receiver,BigDecimal amount) {
		if (sender.getBalance().compareTo(amount) < 0) {

			throw new IllegalArgumentException("Insufficient balance");
		}

		BigDecimal updatedSenderBalance = sender.getBalance().subtract(amount);

		BigDecimal updatedReceiverBalance = receiver.getBalance().add(amount);

		repository.updateBalance(sender.getId(), updatedSenderBalance);
		repository.updateBalance(receiver.getId(), updatedReceiverBalance);
		// intentional rollback testing
//		if (true) {
//			throw new RuntimeException("Transfer failed intentionally");
//		}
//		
	}

	public List<Account> getAllAccounts() {

		return repository.findAll();
	}
}