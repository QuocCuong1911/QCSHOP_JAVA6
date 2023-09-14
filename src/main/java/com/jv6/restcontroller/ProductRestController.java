package com.jv6.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv6.entity.Products;
import com.jv6.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductRestController {

	@Autowired
	ProductService prdService;
	
	@GetMapping("/product/pagination")
	public List<Products> ProductPage(){
		
		return prdService.findAll();
	}
}
