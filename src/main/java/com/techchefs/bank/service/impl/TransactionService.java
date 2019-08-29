package com.techchefs.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techchefs.bank.commons.exception.TransactionNotFoundException;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.commons.response.TransactionResponse;
import com.techchefs.bank.dao.entities.Transaction;
import com.techchefs.bank.dao.repository.TransactionRepository;
import com.techchefs.bank.service.ITransactionService;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionResponse getAll(TransactioRequest request) {
		TransactionResponse reponse = new TransactionResponse();
		Pageable pageable = PageRequest.of(request.getPageId(), request.getPageCount());
		Page<Transaction> tranPage = transactionRepository.findAll(pageable);
		List<Transaction> transactions = tranPage.getContent();
		reponse.setTransactions(transactions);
		reponse.setTotalCount(tranPage.getTotalElements());
		return reponse;
	}

	@Override
	public Transaction findByID(Long id) throws TransactionNotFoundException {
		Optional<Transaction> tran = transactionRepository.findById(id);
		if(tran.isPresent()) {
			return tran.get();
		}
		else {
			throw new TransactionNotFoundException();
		}
	}

}
