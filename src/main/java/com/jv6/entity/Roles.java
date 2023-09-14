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
@Table(name = "roles")
public class Roles implements Serializable{
	@Id
	@Column(name = "id")
	String id;
	
	@Column(name = "name_role")
	String nameRole;
	
	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authorities> listAuthorities;
}
