package com.techchefs.bank.service.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techchefs.bank.commons.exception.ClientNotFoundException;
import com.techchefs.bank.commons.model.Status;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.dao.repository.ClientRepository;
import com.techchefs.bank.service.impl.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {
	
	@Mock
	private ClientService clientService;
	
	@Mock
	private ClientRepository clientRepository;
	
	private Client client;
	
	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setClientId(56l);
		client.setAddress("btm");
		client.setAdharCardNo("12343");
		client.setEmail("abc@gmail.com");
		client.setMobile(7676852817l);
		client.setName("arjun kr");
		client.setProfileUrl("http:67:abc");
		client.setStatus(Status.ACTIVE.toString());
		clientRepository.save(client);
	}

	@Test
	public void shouldCreateClient() throws IOException {
		clientService.addClient(client);
	}
	
	@Test
	public void shouldUpdateClient() throws IOException {
		clientService.addClient(client);
		client.setAddress("btm 2");
	}
	
	@Test
	public void shouldGetClientById() throws IOException, ClientNotFoundException {
		Client client1 = clientService.getClientById(56l);
		//assertEquals(client.getClientId(), client1.getClientId());
	}
}
