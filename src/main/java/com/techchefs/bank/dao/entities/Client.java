package com.techchefs.bank.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clientId;
	
	@NonNull
	private String name;
	
	@NonNull
	private long mobile;
	
	@NonNull
	private String email;
	
	@NonNull
	private String address;
	
	@NonNull
	private String adharCardNo;
	
	private String status;
	
	private String profileUrl;
}
