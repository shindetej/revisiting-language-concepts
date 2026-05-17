package com.tejas.wallet.service;

import com.tejas.wallet.model.Account;
import com.tejas.wallet.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private WalletService walletService;

    @Test
    void transfer_ShouldTransferMoneySuccessfully() {

        // Arrange

        Account sender = new Account()
                .setId(1L)
                .setName("Tejas")
                .setBalance(new BigDecimal("1000"));

        Account receiver = new Account()
                .setId(2L)
                .setName("Raj")
                .setBalance(new BigDecimal("500"));

        when(repository.findById(1L))
                .thenReturn(Optional.of(sender));

        when(repository.findById(2L))
                .thenReturn(Optional.of(receiver));

        // Act

        walletService.transfer(
                1L,
                2L,
                new BigDecimal("200")
        );

        // Assert

        verify(repository)
                .updateBalance(1L, new BigDecimal("800"));

        verify(repository)
                .updateBalance(2L, new BigDecimal("700"));
    }

    @Test
    void transfer_ShouldThrowException_WhenSenderAccountNotFound() {

        // Arrange

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        // Act + Assert

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> walletService.transfer(
                                1L,
                                2L,
                                new BigDecimal("100")
                        )
                );

        assertEquals(
                "Sender account not found",
                exception.getMessage()
        );

        verify(repository, never())
                .updateBalance(anyLong(), any());
    }

    @Test
    void transfer_ShouldThrowException_WhenReceiverAccountNotFound() {

        // Arrange

        Account sender = new Account()
                .setId(1L)
                .setBalance(new BigDecimal("1000"));

        when(repository.findById(1L))
                .thenReturn(Optional.of(sender));

        when(repository.findById(2L))
                .thenReturn(Optional.empty());

        // Act + Assert

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> walletService.transfer(
                                1L,
                                2L,
                                new BigDecimal("100")
                        )
                );

        assertEquals(
                "Receiver account not found",
                exception.getMessage()
        );

        verify(repository, never())
                .updateBalance(anyLong(), any());
    }

    @Test
    void transfer_ShouldThrowException_WhenBalanceInsufficient() {

        // Arrange

        Account sender = new Account()
                .setId(1L)
                .setBalance(new BigDecimal("100"));

        Account receiver = new Account()
                .setId(2L)
                .setBalance(new BigDecimal("500"));

        when(repository.findById(1L))
                .thenReturn(Optional.of(sender));

        when(repository.findById(2L))
                .thenReturn(Optional.of(receiver));

        // Act + Assert

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> walletService.transfer(
                                1L,
                                2L,
                                new BigDecimal("200")
                        )
                );

        assertEquals(
                "Insufficient balance",
                exception.getMessage()
        );

        verify(repository, never())
                .updateBalance(anyLong(), any());
    }

    @Test
    void getAllAccounts_ShouldReturnAllAccounts() {

        // Arrange

        List<Account> accounts = List.of(
                new Account()
                        .setId(1L)
                        .setName("Tejas")
                        .setBalance(new BigDecimal("1000")),

                new Account()
                        .setId(2L)
                        .setName("Raj")
                        .setBalance(new BigDecimal("500"))
        );

        when(repository.findAll())
                .thenReturn(accounts);

        // Act

        List<Account> result = walletService.getAllAccounts();

        // Assert

        assertEquals(2, result.size());

        assertEquals("Tejas", result.get(0).getName());

        assertEquals(
                new BigDecimal("1000"),
                result.get(0).getBalance()
        );

        verify(repository)
                .findAll();
    }

    @Test
    void updateAccountBalances_ShouldUpdateBalancesSuccessfully() {

        // Arrange

        Account sender = new Account()
                .setId(1L)
                .setBalance(new BigDecimal("1000"));

        Account receiver = new Account()
                .setId(2L)
                .setBalance(new BigDecimal("300"));

        // Act

        walletService.updateAccountBalances(
                sender,
                receiver,
                new BigDecimal("200")
        );

        // Assert

        verify(repository)
                .updateBalance(1L, new BigDecimal("800"));

        verify(repository)
                .updateBalance(2L, new BigDecimal("500"));
    }

    @Test
    void updateAccountBalances_ShouldThrowException_WhenBalanceInsufficient() {

        // Arrange

        Account sender = new Account()
                .setId(1L)
                .setBalance(new BigDecimal("50"));

        Account receiver = new Account()
                .setId(2L)
                .setBalance(new BigDecimal("300"));

        // Act + Assert

        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> walletService.updateAccountBalances(
                                sender,
                                receiver,
                                new BigDecimal("100")
                        )
                );

        assertEquals(
                "Insufficient balance",
                exception.getMessage()
        );

        verify(repository, never())
                .updateBalance(anyLong(), any());
    }
}