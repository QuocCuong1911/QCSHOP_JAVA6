package com.jv6.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Accounts implements Serializable{

	@Id
	@Column(name = "username")
	@Size(min = 5, message = "Tên tài khoản quá ngắn")
	@NotBlank(message = "Tài khoản không được trống")
	String username;
	
	@Column(name = "pass")
	@Size(min = 5, message = "Mật khẩu quá ngắn")
	@NotBlank(message = "Mật khẩu không được trống")
	String pass;
	
	@NotBlank(message = "Nhập vào tên đầy đủ của bạn")
	@Column(name = "fullname")
	String fullname;
	
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Tài khoản email không hợp lệ")
	@Column(name = "email")
	String email;
	
	@Column(name = "photo")
	String photo;
	
	@NotBlank(message = "Số điện thoại không được để trống")
	@Pattern(regexp = "^\\d{10}$", message = "Số điện thoại không hợp lệ")
	@Column(name = "phone")
	String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Authorities> listAuthorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Order> listOrders;
}
