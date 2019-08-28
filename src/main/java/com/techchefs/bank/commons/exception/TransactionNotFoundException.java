package com.techchefs.bank.commons.exception;

public class TransactionNotFoundException extends Exception {
	public TransactionNotFoundException() {
        super("Transaction not found");
    }
}
