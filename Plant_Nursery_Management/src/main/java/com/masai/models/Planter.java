package com.masai.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	private float planterHeight;
	private float planterCapacity;
	private Integer drainageHoles;
	private Integer planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	
	@OneToMany(cascade= CascadeType.ALL)
	Set<Seed> Seeds = new HashSet<>();
	
	@OneToMany(cascade= CascadeType.ALL)
	Set<Plant> Plants = new HashSet<>();
}
