package com.jv6.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv6.entity.Accounts;
import com.jv6.entity.Authorities;
import com.jv6.entity.Roles;
import com.jv6.service.AccountService;
import com.jv6.service.AuthoritiesService;
import com.jv6.service.RoleService;
import com.jv6.validate.ApplicationExceptionHandler;
import com.jv6.validate.EmptyValues;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/qcshop")
public class AccountRestController {
	
	@Autowired
	AccountService accService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	AuthoritiesService authoritiesService;
	
	@GetMapping("/accounts/getall")
	public ResponseEntity<List<Accounts>> getAll(){
		return ResponseEntity.ok(accService.getAllAccounts());
	}
	
	@PostMapping("/signup/newaccount")
	public ResponseEntity<Accounts> newAcc( @RequestBody @Valid Accounts acc) {
	
		if(accService.userExit(acc.getUsername()) || accService.emailExit(acc.getEmail())) {
			return ResponseEntity.badRequest().build();
		}
		
		Accounts createAccount = accService.newAcc(acc);
		
		Roles userRole = roleService.findRoleById("ROLE_USER");
		
		Authorities userAuthorities = new Authorities();
		userAuthorities.setAcc(createAccount);
		userAuthorities.setRole(userRole);
		authoritiesService.saveAccountAuthorities(userAuthorities);
		return new ResponseEntity<>(createAccount, HttpStatus.CREATED);
	}
	
	@GetMapping("/checkusernameexits/{username}")
	public Map<String, Boolean> checkUsernameAvailability(@PathVariable("username") String username) {
        Map<String, Boolean> response = new HashMap<>();
        
        // Kiểm tra xem tên người dùng đã tồn tại trong cơ sở dữ liệu hay chưa
        boolean isAvailable = !accService.userExit(username);

        response.put("available", isAvailable);

        return response;
    }
	
	@GetMapping("/checkemailexits/{email}")
	public Map<String, Boolean> checkEmailAvailability(@PathVariable("email") String email) {
        Map<String, Boolean> response = new HashMap<>();       
       
        boolean isAvailable = !accService.emailExit(email);
        response.put("available", isAvailable);
        return response;
    }
}
