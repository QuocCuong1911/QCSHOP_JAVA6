package com.jv6.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jv6.entity.Products;
import com.jv6.repository.ProductRepository;
import com.jv6.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prdRepo;
	
	@Override
	public List<Products> findAll() {
		// TODO Auto-generated method stub
		return prdRepo.findAll();
	}

	@Override
	public Products getProductDetail(String id) {
		// TODO Auto-generated method stub
		return prdRepo.findById(id).get();
	}

	@Override
	public List<Products> getFourProductDT() {
		// TODO Auto-generated method stub
		return prdRepo.getFourProductsDT();
	}

	@Override
	public List<Products> getFourProducLT() {
		// TODO Auto-generated method stub
		return prdRepo.getFourProductsLT();
	}

	@Override
	public List<Products> getFourProductPK() {
		// TODO Auto-generated method stub
		return prdRepo.getFourProductsPK();
	}

	@Override
	public Products findProductsById(String id) {
		// TODO Auto-generated method stub
		return prdRepo.findById(id).get();
	}

//	@Override
//	public <Products> findProductsByCateId(String id) {
//		// TODO Auto-generated method stub
//		return prdRepo.findProductsByCateId(id);
//	}

	@Override
	public Page<Products> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.prdRepo.findAll(pageable);
	}

	@Override
	public Page<Products> findProductsByCateId(String id, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);		
		return prdRepo.findProductsByCateId(id, pageable);
	}

	
}
