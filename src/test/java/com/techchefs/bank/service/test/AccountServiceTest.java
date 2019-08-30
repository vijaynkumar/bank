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
import com.techchefs.bank.commons.request.AccountRequest;
import com.techchefs.bank.dao.entities.Account;
import com.techchefs.bank.dao.entities.Client;
import com.techchefs.bank.dao.repository.AccountRepository;
import com.techchefs.bank.dao.repository.ClientRepository;
import com.techchefs.bank.service.impl.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@Mock
	private AccountService accountService;

	private AccountRequest request;

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private ClientRepository clientRepository;

	private Client client;

	private Account account;

	@Before
	public void setUp() throws Exception {

		client = new Client();
		client.setClientId(27l);
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

		request = new AccountRequest();
		request.setClientId(27l);
		request.setType("CURRENT");
	}

	@Test
	public void shouldCreateAccount() throws IOException {
		accountService.addAccount(request);
	}

	@Test
	public void shouldGetAccountById() throws IOException, AccountNotFoundException {
		Account account1 = accountService.getAccountById(23l);
		//assertEquals(account1.getAccountId(),account.getAccountId());
	}

	@Test
	public void shouldDeleteAccount() throws IOException, AccountNotFoundException {
		accountService.addAccount(request);
		accountService.deleteAccount(23l);
	}

}
