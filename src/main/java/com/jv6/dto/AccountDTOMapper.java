package com.jv6.dto;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jv6.entity.Accounts;


@Service
public class AccountDTOMapper implements Function<Accounts, AccountDTO>{

	@Override
	public AccountDTO apply(Accounts acc) {
		// TODO Auto-generated method stub
		return new AccountDTO(
				acc.getUsername(), 
				acc.getPass(), 
				acc.getListAuthorities()
				.stream()
				.map(role -> role.getRole().getId())
				.collect(Collectors.toList())
				) ;
	}
	
}
