package com.techchefs.bank.service;

import javax.security.auth.login.AccountNotFoundException;

import com.techchefs.bank.commons.exception.InsufficientBalanceException;
import com.techchefs.bank.commons.request.AccountRequest;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.dao.entities.Account;

public interface IAccountService {
	void addAccount(AccountRequest request);

	void deleteAccount(Long id) throws AccountNotFoundException;

	Account getAccountById(Long id) throws AccountNotFoundException;

	void creditBalance(TransactioRequest request) throws AccountNotFoundException;

	void debitBalance(TransactioRequest request) throws AccountNotFoundException, InsufficientBalanceException;
}
