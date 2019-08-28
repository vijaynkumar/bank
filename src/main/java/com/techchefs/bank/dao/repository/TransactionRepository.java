package com.techchefs.bank.dao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.techchefs.bank.dao.entities.Transaction;

@Repository
public interface TransactionRepository
		extends JpaRepository<Transaction, UUID>, PagingAndSortingRepository<Transaction, UUID> {
	Page<Transaction> findAll(Pageable pageable);

	Optional<Transaction> findById(UUID id);
}
