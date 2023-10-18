package com.jv6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jv6.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, String>{
	@Query("SELECT acc FROM Accounts acc WHERE acc.username = ?1")
	Optional<Accounts> findByUsername(String username);
	
	@Query("SELECT acc FROM Accounts acc WHERE acc.email = ?1")
	Optional<Accounts> exitByEmail(String email);
}
