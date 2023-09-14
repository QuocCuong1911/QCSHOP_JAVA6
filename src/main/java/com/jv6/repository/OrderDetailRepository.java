package com.jv6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv6.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

}
