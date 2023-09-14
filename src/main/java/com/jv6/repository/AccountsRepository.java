package com.jv6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv6.entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, String>{

}
