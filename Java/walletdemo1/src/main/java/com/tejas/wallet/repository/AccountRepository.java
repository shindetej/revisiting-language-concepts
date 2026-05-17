package com.tejas.wallet.repository;

import com.tejas.wallet.model.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Optional<Account> findById(Long accountId);

    List<Account> findAll();

    int updateBalance(Long accountId, BigDecimal newBalance);
}