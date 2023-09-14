package com.jv6.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "danhmuc")
public class Category implements Serializable{

	@Id
	@Column(name = "madm")
	String cateId;
	
	@Column(name = "tendanhmuc")
	String cateName;
	
	@Column(name = "ghichu")
	String describe;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cate")
	List<Products> listProducts;
}
