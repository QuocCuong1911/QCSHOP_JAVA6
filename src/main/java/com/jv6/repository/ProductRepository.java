package com.jv6.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jv6.entity.Products;


public interface ProductRepository extends JpaRepository<Products, String>{
	@Query(value = "SELECT TOP 4 * FROM sanpham WHERE madm = 'LT' ORDER BY NEWID() ", nativeQuery = true)
	List<Products> getFourProductsLT();
	
	@Query(value = "SELECT TOP 4 * FROM sanpham WHERE madm = 'DT' ORDER BY NEWID()", nativeQuery = true)
	List<Products> getFourProductsDT();
	
	@Query(value = "SELECT TOP 4 * FROM sanpham WHERE madm = 'PK' ORDER BY NEWID()", nativeQuery = true)
	List<Products> getFourProductsPK();
	
	@Query("SELECT p FROM Products p WHERE p.cate.cateId = ?1")
	Page<Products> findProductsByCateId(String id, Pageable pageable);
}
