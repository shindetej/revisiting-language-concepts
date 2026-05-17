package com.tejas.wallet.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.tejas.wallet.model.Account;
import com.tejas.wallet.service.WalletService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(WalletController.class)
class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WalletService walletService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAccounts_ShouldReturnAccountsList() throws Exception {

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

        when(walletService.getAllAccounts())
                .thenReturn(accounts);

        // Act + Assert

        mockMvc.perform(get("/wallet/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Tejas"))
                .andExpect(jsonPath("$[0].balance").value(1000))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Raj"))
                .andExpect(jsonPath("$[1].balance").value(500));

        verify(walletService)
                .getAllAccounts();
    }

    @Test
    void transfer_ShouldReturnSuccessMessage() throws Exception {

        // Act + Assert

        mockMvc.perform(
                        post("/wallet/transfer")
                                .param("from", "1")
                                .param("to", "2")
                                .param("amount", "200")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Transfer successful"));

        verify(walletService)
                .transfer(
                        1L,
                        2L,
                        new BigDecimal("200")
                );
    }

    @Test
    void transfer_ShouldReturnBadRequest_WhenAmountMissing() throws Exception {

        // Act + Assert

        mockMvc.perform(
                        post("/wallet/transfer")
                                .param("from", "1")
                                .param("to", "2")
                )
                .andExpect(status().isBadRequest());

        verify(walletService, never())
                .transfer(anyLong(), anyLong(), any());
    }

    @Test
    void transfer_ShouldReturnBadRequest_WhenFromMissing() throws Exception {

        // Act + Assert

        mockMvc.perform(
                        post("/wallet/transfer")
                                .param("to", "2")
                                .param("amount", "200")
                )
                .andExpect(status().isBadRequest());

        verify(walletService, never())
                .transfer(anyLong(), anyLong(), any());
    }

    @Test
    void transfer_ShouldReturnBadRequest_WhenToMissing() throws Exception {

        // Act + Assert

        mockMvc.perform(
                        post("/wallet/transfer")
                                .param("from", "1")
                                .param("amount", "200")
                )
                .andExpect(status().isBadRequest());

        verify(walletService, never())
                .transfer(anyLong(), anyLong(), any());
    }

    @Test
    void transfer_ShouldHandleServiceException() throws Exception {

        // Arrange

        doThrow(new IllegalArgumentException("Insufficient balance"))
                .when(walletService)
                .transfer(
                        1L,
                        2L,
                        new BigDecimal("200")
                );

        // Act + Assert

        mockMvc.perform(
                        post("/wallet/transfer")
                                .param("from", "1")
                                .param("to", "2")
                                .param("amount", "200")
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Insufficient balance"));
    }
}