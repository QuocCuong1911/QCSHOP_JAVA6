package com.jv6.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderr")
public class Order implements Serializable{

	@Id
	@Column(name = "id")
	String orderId;
	
	@ManyToOne
	@JoinColumn(name = "username")
	Accounts acc;
	
	@Column(name = "createDate")
	@Temporal(TemporalType.DATE)
	Date createDate;
	
	@Column(name = "addresss")
	String address;
	
	@Column(name = "statuss")
	int status;
	
	@OneToMany(mappedBy = "order")
	@JsonIgnore
	List<OrderDetail> listOrderDetails;
}
