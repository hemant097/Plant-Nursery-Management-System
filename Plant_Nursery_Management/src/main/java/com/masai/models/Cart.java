package com.masai.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartItemId;

	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;

//	private Double cartTotal;

	@OneToOne(cascade = CascadeType.ALL)
	private Planter planter;

	private Integer planterId;

}