package com.jv6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jv6.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

	@Query("SELECT od.orderId FROM Order od")
	List<String> getAllOrderId();
}
