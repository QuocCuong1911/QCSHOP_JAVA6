package com.jv6.service;

import java.util.List;

import com.jv6.entity.Accounts;

public interface AccountService {
	Accounts newAcc(Accounts acc);
	
	List<Accounts> getAllAccounts();
	
	Boolean userExit(String username);
	
	Boolean emailExit(String email);
}
