package com.jv6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jv6.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
