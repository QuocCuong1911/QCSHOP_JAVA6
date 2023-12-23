package com.jv6.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jv6.config.UserInfoToUserDetail;
import com.jv6.dto.AccountDTO;
import com.jv6.entity.Accounts;
import com.jv6.repository.AccountsRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

	private final AccountsRepository AccRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Accounts> accInfo = AccRepo.findByUsername(username);

		return accInfo.map(UserInfoToUserDetail::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found : " + username));
	}

}
