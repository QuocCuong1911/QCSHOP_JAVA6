package com.jv6.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jv6.entity.Accounts;
import com.jv6.repository.AccountsRepository;
import com.jv6.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AccountsRepository accRepo;

	@Override
	public Accounts newAcc(Accounts acc) {
		// TODO Auto-generated method stub
		acc.setPass(passwordEncoder.encode(acc.getPass()));
		return accRepo.save(acc);
	}

	@Override
	public List<Accounts> getAllAccounts() {
		// TODO Auto-generated method stub
		return accRepo.findAll();
	}

	@Override
	public Boolean userExit(String username) {
		// TODO Auto-generated method stub
		return accRepo.existsById(username);
	}

	@Override
	public Boolean emailExit(String email) {
		// TODO Auto-generated method stub
		Optional<Accounts> accEmail = accRepo.exitByEmail(email);		
		return accEmail.isPresent();
	}

}
