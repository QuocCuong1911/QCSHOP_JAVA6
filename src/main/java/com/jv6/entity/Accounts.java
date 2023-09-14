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
@Table(name = "accounts")
public class Accounts implements Serializable{

	@Id
	@Column(name = "username")
	String username;
	
	@Column(name = "pass")
	String pass;
	
	@Column(name = "fullname")
	String fullname;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "photo")
	String photo;
	
	@Column(name = "phone")
	String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Authorities> listAuthorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "acc")
	List<Order> listOrders;
}
