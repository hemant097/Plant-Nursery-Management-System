package com.masai.models;

import java.util.ArrayList;
import java.util.List;

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
	private Double planterHeight;
	private Double planterCapacity;
	private Integer drainageHoles;
	private String planterColor;
	private String planterShape;
	private Integer planterStock;
	private Integer planterCost;
	
	@OneToMany(cascade= CascadeType.ALL)
	List<Seed> Seeds = new ArrayList<>();
	
	@OneToMany(cascade= CascadeType.ALL)
	List<Plant> Plants = new ArrayList<>();
}
