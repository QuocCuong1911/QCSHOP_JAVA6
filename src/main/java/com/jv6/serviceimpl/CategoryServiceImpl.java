package com.jv6.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv6.entity.Category;
import com.jv6.repository.CategoryRepository;
import com.jv6.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository cateRepo;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateRepo.findAll();
	}

}
