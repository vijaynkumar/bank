package com.techchefs.bank.service.test;

import java.io.IOException;
import java.util.Date;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techchefs.bank.commons.model.AccountType;
import com.techchefs.bank.commons.model.Status;
import com.techchefs.bank.commons.request.TransactioRequest;
import com.techchefs.bank.commons.response.TransactionResponse;
import com.techchefs.bank.dao.entities.Account;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.dao.repository.AccountRepository;
import com.techchefs.bank.dao.repository.ClientRepository;
import com.techchefs.bank.service.impl.AccountService;
import com.techchefs.bank.service.impl.ClientService;
import com.techchefs.bank.service.impl.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	
	@Mock
	private TransactionService transactionService;
	
	@Mock
	private AccountService accountService;
	
	@Mock
	private ClientService clientService;
	
	@Mock
	private AccountRepository accountRepository;
	
	@Mock
	private ClientRepository clientRepository;
	
	private TransactioRequest transactioRequest;
	
	private Client client;
	
	private Account account;
	
	private TransactioRequest request;
	
	@Before
	public void setUp() throws Exception {
		
		client = new Client();
		client.setClientId(20l);
		client.setAddress("btm");
		client.setAdharCardNo("12343");
		client.setEmail("abc@gmail.com");
		client.setMobile(7676852817l);
		client.setName("arjun kr");
		client.setProfileUrl("http:67:abc");
		client.setStatus(Status.ACTIVE.toString());
		clientRepository.save(client);
		
		account = new Account();
		account.setAccountId(23l);
		account.setAccountNumber(1020102030304049l);
		account.setBalance(200.0);
		account.setCreatedDate(new Date());
		account.setOwner(client);
		account.setStatus(Status.ACTIVE.toString());
		account.setType(AccountType.CURRENT.toString());
		accountRepository.save(account);
		
		transactioRequest = new TransactioRequest();
		transactioRequest.setAccountId(23l);
		transactioRequest.setAmount(200.0);
		
		request = new TransactioRequest();
		request.setPageId(0);
		request.setPageCount(10);
	}

	@Test
	public void shouldGetListOfTransaction() throws IOException, AccountNotFoundException {
		accountService.creditBalance(transactioRequest);
		TransactionResponse res = transactionService.getAll(request);
		//assertEquals(res.getTotalCount(), 1);
	}
}
