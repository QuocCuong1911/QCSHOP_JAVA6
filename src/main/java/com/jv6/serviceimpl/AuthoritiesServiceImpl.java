package com.jv6.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv6.entity.Authorities;
import com.jv6.repository.AuthoritiesRepository;
import com.jv6.service.AuthoritiesService;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

	@Autowired
	AuthoritiesRepository authoritiesRepo;
	@Override
	public Authorities saveAccountAuthorities(Authorities authorities) {
		// TODO Auto-generated method stub
		return authoritiesRepo.save(authorities);
	}
	
}
