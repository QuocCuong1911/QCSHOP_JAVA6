package com.jv6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

	@RequestMapping("/order/checkout")
	public String checkout() {
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
