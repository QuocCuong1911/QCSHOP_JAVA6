package com.jv6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jv6.entity.Products;
import com.jv6.service.ProductService;


@Controller
@RequestMapping("/qcshop")
public class ProductController {

	@Autowired
	ProductService prdService;
	
	@RequestMapping(value = {"/product/home", "/home", "/"})
	public String home(Model model) {
		List<Products> listProductsDT = prdService.getFourProductDT();
		model.addAttribute("listProductDT", listProductsDT);
		
		List<Products> listProductsLT = prdService.getFourProducLT();
		model.addAttribute("listProductLT", listProductsLT);
		
		List<Products> listProductsPK = prdService.getFourProductPK();
		model.addAttribute("listProductPK", listProductsPK);
		
		List<Products> listProducts = prdService.findAll();
		model.addAttribute("listProduct", listProducts);
		
		printRemoteUser();
		System.out.println("/product/home");
		return "product/list.html";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") String id) {
		
		Products productDetail = prdService.findProductsById(id);
		model.addAttribute("productsDetail", productDetail);
		
		List<Products> listProductsRelated ;
		String idCut = id.substring(0,2);
		
		System.out.println(idCut);
		
		switch (idCut) {
		case "DT": {			
			listProductsRelated = prdService.getFourProductDT();			
			break;
		}
		case "LT": {			
			listProductsRelated = prdService.getFourProducLT();			
			break;
		}
		case "PK": {			
			listProductsRelated = prdService.getFourProductPK();			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + id);
		}
		
		model.addAttribute("listProductsRelated", listProductsRelated);
		
		System.out.println(id);
		System.out.println("listsize : " +listProductsRelated.size());
		
		if (productDetail != null) {
			System.out.println(productDetail.getProductName());
		}else {
			System.out.println("Không tìm được rồi");
		}
		
		return "product/detail.html";
	}
	
	@RequestMapping("/products/listcate/{id}/{pageNo}")
	public String productCate(Model model, @PathVariable("id") String id, @PathVariable("pageNo") int pageNo) {
		int pageSize = 8;
		
		Page<Products> page = prdService.findProductsByCateId(id, pageNo, pageSize);
		List<Products> listProducts = page.getContent();
		
		model.addAttribute("cateId", id);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listProductsCate", listProducts);
		
		
		return "product/productsCate.html";
	}
	
	@GetMapping("/product/page/{pageNo}")
	public String findPaginated(@PathVariable("pageNo") int pageNo, Model model) {
		
		int pageSize = 8;
		
		Page<Products> page = prdService.findPaginated(pageNo, pageSize);
		List<Products> listPage = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listProuductPage", listPage);
		
		return "product/productsCate.html";	
	}
	
	public void printRemoteUser() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    Object principal = authentication.getPrincipal();
	    if (principal instanceof String) {
	        // Đây là tên người dùng (remoteUser)
	        String remoteUser = (String) principal;
	        System.out.println("Remote User: " + remoteUser);
	    } else {
	        System.out.println("Remote User is not available or not authenticated.");
	    }
	}
	
	public void printAuthenticationInfo() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        String authenticationJson = objectMapper.writeValueAsString(authentication);
	        System.out.println("Authentication Info: " + authenticationJson);
	    } catch (JsonProcessingException e) {
	        System.out.println("Failed to convert Authentication to JSON: " + e.getMessage());
	    }
	}
}
