package com.techchefs.bank.commons.exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
        super("Insufficient balance");
    }
}
