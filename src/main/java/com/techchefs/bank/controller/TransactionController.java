package com.techchefs.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.bank.commons.exception.TransactionNotFoundException;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.commons.response.TransactionResponse;
import com.techchefs.bank.dao.entities.Transaction;
import com.techchefs.bank.service.ITransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> getAll(@RequestBody TransactioRequest request) {
		TransactionResponse transaction = transactionService.getAll(request);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getTransactions(@PathVariable Long id) throws TransactionNotFoundException {
		Transaction transaction = transactionService.findByID(id);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}
}
