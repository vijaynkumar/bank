package com.techchefs.bank.dao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techchefs.bank.dao.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID>{
	
	@Query(value = "select max account_no from account", nativeQuery = true)
	long getMaxAccountNumber();
	
	Optional<Account> findById(UUID accountNumber);
}
