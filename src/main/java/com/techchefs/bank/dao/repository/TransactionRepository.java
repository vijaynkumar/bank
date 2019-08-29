package com.techchefs.bank.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.techchefs.bank.dao.entities.Transaction;

@Repository
public interface TransactionRepository
		extends JpaRepository<Transaction, Long>, PagingAndSortingRepository<Transaction, Long> {

	Optional<Transaction> findById(Long id);
}
