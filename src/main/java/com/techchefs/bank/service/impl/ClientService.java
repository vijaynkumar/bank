package com.techchefs.bank.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchefs.bank.commons.exception.ClientNotFoundException;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.dao.repository.ClientRepository;
import com.techchefs.bank.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void addClient(Client client) {
		clientRepository.save(client);
	}

	@Override
	public void updateClient(Client client) throws ClientNotFoundException {
	    Optional<Client> oldClientOp = clientRepository.findById(client.getId());
	    if(oldClientOp.isPresent()) {
	    	Client oldClient = oldClientOp.get();
	    	oldClient.setAddress(client.getAddress());
	    	oldClient.setAdharCardNo(client.getAdharCardNo());
	    	oldClient.setEmail(client.getEmail());
	    	oldClient.setMobile(client.getMobile());
	    	oldClient.setName(client.getName());
	    	oldClient.setProfileUrl(client.getProfileUrl());
	    	clientRepository.save(oldClient);
	    }
	    else {
	    	throw new ClientNotFoundException();
	    }
	}

	@Override
	public Client getClientById(UUID id) throws ClientNotFoundException{
		 Optional<Client> oldClientOp = clientRepository.findById(id);
		    if(oldClientOp.isPresent()) {
		    	return oldClientOp.get();
		    }
		    else {
		    	throw new ClientNotFoundException();
		    }
	}

}
