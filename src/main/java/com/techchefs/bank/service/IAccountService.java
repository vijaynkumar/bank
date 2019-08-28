package com.techchefs.bank.service;

import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import com.techchefs.bank.commons.exception.InsufficientBalanceException;
import com.techchefs.bank.commons.request.AccountRequest;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.dao.entities.Account;

public interface IAccountService {
	void addAccount(AccountRequest request);

	void deleteAccount(UUID id) throws AccountNotFoundException;

	Account getAccountById(UUID id) throws AccountNotFoundException;

	void creditBalance(TransactioRequest request) throws AccountNotFoundException;

	void debitBalance(TransactioRequest request) throws AccountNotFoundException, InsufficientBalanceException;
}
