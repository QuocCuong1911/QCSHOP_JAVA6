package com.jv6.service;

import java.util.List;
import java.util.Optional;

import com.jv6.dto.AccountDTO;
import com.jv6.entity.Accounts;

public interface AccountService {
	Accounts newAcc(Accounts acc);
	
	List<Accounts> getAllAccounts();
	
	Boolean userExit(String username);
	
	Boolean emailExit(String email);
	
	Accounts findById(String username);
//	Optional<AccountDTO> convertAccDTO(String username);
}
