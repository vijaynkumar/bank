package com.techchefs.bank.commons.exception;

public class ClientNotFoundException extends Exception{
	public ClientNotFoundException() {
        super("Clinet not found");
    }
}
