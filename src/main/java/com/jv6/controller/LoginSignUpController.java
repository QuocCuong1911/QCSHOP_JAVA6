
package com.jv6.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jv6.entity.Accounts;
import com.jv6.repository.AccountsRepository;

@RequestMapping("/qcshop")

@Controller
public class LoginSignUpController {

	@Autowired
	AccountsRepository accRepo;
	@RequestMapping("/login")
	public String loginandsignup(Model model) {
		
		printAuthenticationInfo();
		System.out.println("loginandsignup");
		
//		Optional<Accounts> acc = accRepo.findById("admin");
//		Accounts accounts = acc.get();
//		String roles = accounts.getListAuthorities().stream()
//			    .map(user -> user.getRole().getId())
//			    .collect(Collectors.joining(","));
//
//		System.out.println(roles);	
		return "layout/login_ands_signup.html";
	}
	
	@RequestMapping("/login/success")
	public String loginSuccess() {
		System.out.println("Login thành công");
		
		printAuthenticationInfo();
		System.out.println("loginSuccess");
		return "redirect:/qcshop/product/home";
	}
	
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		System.out.println("Login sai");
		
		return "layout/login_ands_signup.html";
	}
	
//	public void printRemoteUser() {
//	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    Object principal = authentication.getPrincipal();
//	    if (principal instanceof String) {
//	        // Đây là tên người dùng (remoteUser)
//	        String remoteUser = (String) principal;
//	        System.out.println("Remote User: " + remoteUser);
//	    } else {
//	        System.out.println("Remote User is not available or not authenticated.");
//	    }
//	}
//	
	public void printAuthenticationInfo() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        String authenticationJson = objectMapper.writeValueAsString(authentication);
	        System.out.println("Authentication Info: " + authenticationJson);
	        
	        JsonNode authenticationNode = objectMapper.readTree(authenticationJson);
	        JsonNode principalNode = authenticationNode.get("principal");

	        if (principalNode.isObject() && principalNode.has("username")) {
	            // Đã đăng nhập, truy cập giá trị "username"
	            String username = principalNode.get("username").asText();
	            System.out.println("Username: " + username);
	        } else {
	            // Chưa đăng nhập
	            System.out.println("Not logged in");
	        }
	    } catch (JsonProcessingException e) {
	        System.out.println("Failed to convert Authentication to JSON: " + e.getMessage());
	    }
	}
}
