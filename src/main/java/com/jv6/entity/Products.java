package com.jv6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sanpham")
public class Products implements Serializable{

	@Id
	@Column(name = "masp")
	String productId;
	
	@Column(name = "tensp")
	String productName;
	
	@Column(name = "giasp")
	Double price;
	
	@Column(name = "mota")
	String describe;
	
	@Column(name = "hinh")
	String photo;
	
	@Column(name = "soluong")
	int quantity;
	
	@ManyToOne
	@JoinColumn(name = "madm")
	Category cate;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	List<OrderDetail> lisOrderDetails;
	

}
