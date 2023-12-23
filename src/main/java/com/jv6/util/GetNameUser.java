package com.jv6.util;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jv6.entity.Accounts;
import com.jv6.service.AccountService;

@Component
public class GetNameUser {
	@Autowired
	AccountService accService;
	public String getFullNameUser() {
		String nameUser = "";
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    
		    try {
		        ObjectMapper objectMapper = new ObjectMapper();
		        String authenticationJson = objectMapper.writeValueAsString(authentication);   
		        JsonNode authenticationNode = objectMapper.readTree(authenticationJson);
		        JsonNode principalNode = authenticationNode.get("principal");

		        if (principalNode.isObject() && principalNode.has("username")) {
		            // Đã đăng nhập, truy cập giá trị "username"
		            String username = principalNode.get("username").asText();
		            Accounts account = accService.findById(username);
		            if (account != null) {
						nameUser = account.getFullname();
					}
		        } else {
		            // Chưa đăng nhập
		            System.out.println("Not logged in");
		            
		        }
		    } catch (JsonProcessingException e) {
		        System.out.println("Failed to convert Authentication to JSON: " + e.getMessage());
		    }
		    
		    return nameUser;
	}
	
	public String getUsername() {
		String usernameGet = "";
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    
		    try {
		        ObjectMapper objectMapper = new ObjectMapper();
		        String authenticationJson = objectMapper.writeValueAsString(authentication);   
		        JsonNode authenticationNode = objectMapper.readTree(authenticationJson);
		        JsonNode principalNode = authenticationNode.get("principal");

		        if (principalNode.isObject() && principalNode.has("username")) {
		            // Đã đăng nhập, truy cập giá trị "username"
		            String username = principalNode.get("username").asText();
		            usernameGet = username.toLowerCase();
		            System.out.println("Username : " + usernameGet);
		        } else {
		            // Chưa đăng nhập
		            System.out.println("Not logged in");
		            
		        }
		    } catch (JsonProcessingException e) {
		        System.out.println("Failed to convert Authentication to JSON: " + e.getMessage());
		    }
		    
		    return usernameGet;
	}
}
