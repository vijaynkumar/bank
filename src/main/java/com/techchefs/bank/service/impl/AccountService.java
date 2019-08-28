package com.techchefs.bank.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techchefs.bank.commons.exception.InsufficientBalanceException;
import com.techchefs.bank.commons.model.Status;
import com.techchefs.bank.commons.model.TransactionType;
import com.techchefs.bank.commons.request.AccountRequest;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.dao.entities.Account;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.dao.entities.Transaction;
import com.techchefs.bank.dao.repository.AccountRepository;
import com.techchefs.bank.dao.repository.TransactionRepository;
import com.techchefs.bank.service.IAccountService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	private static final long ACOUNT_OFFSET = 1000000000000000l;

	@Override
	public void addAccount(AccountRequest request) {
		Account newAccount = new Account();
		newAccount.setBalance(Double.MIN_VALUE);
		newAccount.setCreatedDate(new Date());
		newAccount.setStatus(Status.ACTIVE.toString());
		newAccount.setType(request.getType());
		Client client = new Client();
		client.setId(request.getClientId());
		newAccount.setOwner(client);
		newAccount.setAccountNumber(generateAccountnumber());
		accountRepository.save(newAccount);
	}

	@Override
	public void deleteAccount(UUID id) throws AccountNotFoundException {
		Optional<Account> acctOpt = accountRepository.findById(id);
		if (acctOpt.isPresent()) {
			Account account = acctOpt.get();
			account.setStatus(Status.INACTIVE.toString());
			accountRepository.save(account);
		} else {
			throw new AccountNotFoundException();
		}
	}

	@Override
	public Account getAccountById(UUID id) throws AccountNotFoundException {
		Optional<Account> acctOpt = accountRepository.findById(id);
		if (acctOpt.isPresent()) {
			return acctOpt.get();
		} else {
			throw new AccountNotFoundException();
		}
	}

	private long generateAccountnumber() {
		long maxAcc = accountRepository.getMaxAccountNumber();
		if (maxAcc == 0l) {
			return ACOUNT_OFFSET;
		}
		return maxAcc + 1;
	}

	@Transactional
	@Override
	public void creditBalance(TransactioRequest request) throws AccountNotFoundException {
		Optional<Account> acctOpt = accountRepository.findById(request.getAccountId());
		if (acctOpt.isPresent()) {
			Account account = acctOpt.get();
			account.setBalance(account.getBalance() + request.getAmount());
			accountRepository.save(account);
			saveTransaction(request, account, TransactionType.CREDIT.toString());
		} else {
			throw new AccountNotFoundException();
		}
	}

	@Transactional
	@Override
	public void debitBalance(TransactioRequest request) throws AccountNotFoundException, InsufficientBalanceException {
		Optional<Account> tranByAcc = accountRepository.findById(request.getTransferByAcctNo());
		Optional<Account> tranToAcc = accountRepository.findById(request.getTransferToAcctNo());
		if (tranByAcc.isPresent() && tranToAcc.isPresent()) {
			Account account = tranByAcc.get();
			if (account.getBalance() - request.getAmount() > 0) {
				account.setBalance(account.getBalance() - request.getAmount());
				accountRepository.save(account);
				saveTransaction(request, account, TransactionType.DEBIT.toString());
				Account transToAcc = tranToAcc.get();
				transToAcc.setBalance(transToAcc.getBalance() + request.getAmount());
				accountRepository.save(transToAcc);
				saveTransaction(request, transToAcc, TransactionType.CREDIT.toString());
			} else {
				throw new InsufficientBalanceException();
			}
		} else {
			throw new AccountNotFoundException();
		}
	}
	
	@Transactional
	public void saveTransaction(TransactioRequest request, Account account, String type) {
		Transaction trans = new Transaction();
		trans.setAccount(account);
		trans.setAmount(request.getAmount());
		trans.setCreatedDate(new Date());
		trans.setType(type);
		transactionRepository.save(trans);
	}

}
