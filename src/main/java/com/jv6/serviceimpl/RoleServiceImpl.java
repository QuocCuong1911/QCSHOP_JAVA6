package com.jv6.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv6.entity.Roles;
import com.jv6.repository.RoleRepository;
import com.jv6.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public Roles findRoleById(String idRole) {
		// TODO Auto-generated method stub
		return roleRepo.findById(idRole).get();
	}

}
