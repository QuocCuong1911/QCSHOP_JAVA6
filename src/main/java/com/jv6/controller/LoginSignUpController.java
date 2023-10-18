
package com.jv6.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jv6.entity.Accounts;
import com.jv6.repository.AccountsRepository;

@RequestMapping("/qcshop")

@Controller
public class LoginSignUpController {

	@Autowired
	AccountsRepository accRepo;
	@RequestMapping("/login")
	public String loginandsignup(Model model) {
	
		return "layout/login_ands_signup.html";
	}
	
	@RequestMapping("/login/success")
	public String loginSuccess() {
		System.out.println("Login thành công");
		return "redirect:/product/home";
	}
	
	@RequestMapping("/login/error")
	public String loginError(Model model) {
		System.out.println("Login sai");
		
		return "layout/login_ands_signup.html";
	}
	
}
