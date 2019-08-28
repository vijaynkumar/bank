package com.techchefs.bank.controller;

import java.util.UUID;

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

import com.techchefs.bank.commons.exception.ClientNotFoundException;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.service.IClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> register(@RequestBody Client client) {
		if(client == null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		clientService.addClient(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create(@RequestBody Client client) throws ClientNotFoundException {
		if(client == null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		clientService.updateClient(client);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create(@PathVariable UUID id) throws ClientNotFoundException {
		if(id == null) {
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Client client = clientService.getClientById(id);
		return new ResponseEntity<>(client, HttpStatus.CREATED);
	}
}
