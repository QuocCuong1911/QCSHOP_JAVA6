package com.jv6.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv6.repository.OrderRepository;
import com.jv6.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public List<String> listOrderId() {
		// TODO Auto-generated method stub
		return orderRepo.getAllOrderId();
	}

}
