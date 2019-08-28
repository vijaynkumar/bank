package com.techchefs.bank.dao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techchefs.bank.dao.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{
	Optional<Client> findById(UUID id);
}
