package com.jv6.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jv6.entity.Products;


public interface ProductService {
	
	List<Products> findAll();
	
	Products getProductDetail(String id);
	
	List<Products> getFourProductDT();
	
	List<Products> getFourProducLT();
	
	List<Products> getFourProductPK();
	
	Products findProductsById(String id);
	
	Page<Products> findProductsByCateId(String id, int pageNo, int pageSize);
	
	Page<Products> findPaginated(int pageNo, int pageSize);
}
