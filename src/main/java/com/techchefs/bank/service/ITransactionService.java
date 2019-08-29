package com.techchefs.bank.service;

import com.techchefs.bank.commons.exception.TransactionNotFoundException;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.commons.response.TransactionResponse;
import com.techchefs.bank.dao.entities.Transaction;

public interface ITransactionService {
	TransactionResponse getAll(TransactioRequest request);

	Transaction findByID(Long id) throws TransactionNotFoundException;
}
