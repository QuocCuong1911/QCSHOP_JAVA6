package com.jv6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv6.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
