package com.techchefs.bank.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techchefs.bank.commons.exception.InsufficientBalanceException;
import com.techchefs.bank.commons.request.AccountRequest;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.dao.entities.Account;
import com.techchefs.bank.service.IAccountService;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create(@RequestBody AccountRequest request) {
		if(request == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		accountService.addAccount(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete(@PathVariable Long id) throws AccountNotFoundException {
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		accountService.deleteAccount(id);	
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> getById(@PathVariable Long id) throws AccountNotFoundException {
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Account account = accountService.getAccountById(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/credit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> credit(@RequestBody TransactioRequest request) throws AccountNotFoundException {
		if(request == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		accountService.creditBalance(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/debit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> debit(@RequestBody TransactioRequest request) throws AccountNotFoundException, InsufficientBalanceException {
		if(request == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		accountService.debitBalance(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
