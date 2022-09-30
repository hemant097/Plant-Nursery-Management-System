package com.masai.models;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private Integer cartId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<CustomerOrder> items=new ArrayList<>();

	private Double cartTotal;
    
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seed> seeds = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Plant> plants = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters = new ArrayList<>();
	
	private Integer noOfItems;
	
}