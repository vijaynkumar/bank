package com.techchefs.bank.commons.request;

import java.util.Date;
import java.util.UUID;

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
public class TransactioRequest {
	private Integer pageId;
	private Integer pageCount;
	private Date startDate;
	private Date endDate;
	private UUID transferToAcctNo;
	private UUID transferByAcctNo;
	private UUID accountId;
	private double amount;
}
