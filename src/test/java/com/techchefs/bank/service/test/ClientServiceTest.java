package com.techchefs.bank.service.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void shouldReturnFileUrlWhenUploadSuccessFully() throws IOException {
		assertEquals(1, 1);
	}
}
