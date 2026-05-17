package com.tejas.wallet.controller;

import com.tejas.wallet.model.Account;
import com.tejas.wallet.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {

	private final WalletService walletService;

	public WalletController(WalletService walletService) {
		this.walletService = walletService;
	}

	@GetMapping("/accounts")
	public List<Account> getAccounts() {

		return walletService.getAllAccounts();
	}

	@PostMapping("/transfer")
	public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount) {

		walletService.transfer(from, to, amount);

		return "Transfer successful";
	}
}