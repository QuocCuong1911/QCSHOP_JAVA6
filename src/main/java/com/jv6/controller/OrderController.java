package com.jv6.controller;

import org.antlr.v4.runtime.misc.TestRig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jv6.util.CreateOrderId;
import com.jv6.util.CurrentDateExample;
import com.jv6.util.GetNameUser;


@Controller
public class OrderController {

	@Autowired
	GetNameUser getNameUser;
	
	@Autowired
	CreateOrderId createOrderId;
	
	@Autowired
	CurrentDateExample currentDateExample;
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {		
		String orderId = createOrderId.generateInvoiceCode();	
		String nameUser = getNameUser.getFullNameUser();
		String username = getNameUser.getUsername();
		String createDate = currentDateExample.currentDate();
		
		
		model.addAttribute("orderId", orderId);
		model.addAttribute("nameUser", nameUser);
		model.addAttribute("username", username);
		model.addAttribute("createDate", createDate);
		
		return "order/ordercheckout.html";
	}
	
	@RequestMapping("/order/list")
	public String list() {
		return "order/orderlist.html";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String detail() {
		return "order/orderdetail.html";
	}
}
