package com.techchefs.bank.commons.response;

import java.util.List;

import com.techchefs.bank.dao.entities.Transaction;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class TransactionResponse {
	private List<Transaction> transactions;
	private long totalCount;
}
