package com.techchefs.bank.service;

import java.util.UUID;

import com.techchefs.bank.commons.exception.ClientNotFoundException;
import com.techchefs.bank.dao.entities.Client;

public interface IClientService {
	void addClient(Client client);
	void updateClient(Client client) throws ClientNotFoundException;
	Client getClientById(UUID id) throws ClientNotFoundException;
}
