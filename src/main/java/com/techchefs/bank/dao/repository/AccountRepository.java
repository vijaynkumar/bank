package com.techchefs.bank.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techchefs.bank.dao.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{
	
	@Query(value = "select MAX(account_number) from account", nativeQuery = true)
	Long getMaxAccountNumber();
	
	Optional<Account> findById(Long accountNumber);
}
