package com.jv6.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv6.entity.Products;
import com.jv6.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {

	@Autowired
	ProductService prdService;
	
	@GetMapping("/product/pagination/{id}/{pageNo}")
	public ResponseEntity<Map<String, Object>> productCate(@PathVariable("id") String id, @PathVariable("pageNo") int pageNo) {
		int pageSize = 8;
		
		Page<Products> page = prdService.findProductsByCateId(id, pageNo, pageSize);
		List<Products> listProducts = page.getContent();
		
		Map<String, Object> paginationMap = new HashMap<>();
		paginationMap.put("cateId", id);
		paginationMap.put("currentPage", pageNo);
		paginationMap.put("totalPage", page.getTotalPages());
		paginationMap.put("totalItems", page.getTotalElements());
		paginationMap.put("listProductsCate", listProducts);
			
		return ResponseEntity.ok(paginationMap);
	}
	
	@GetMapping("{id}")
	public Products getOne(@PathVariable("id") String id) {
		return prdService.findProductsById(id);
	}
}
