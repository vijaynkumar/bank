package com.techchefs.bank.dao.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	
	@Column(name="account_number")
	private long accountNumber;
	
	@Column(name="type")
	private String type;

	@Column(name="balance")
	private double balance;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="status")
	private String status;

    @ManyToOne
    @JoinColumn(name = "id")
	private Client owner;

}
