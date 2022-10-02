package com.masai.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	@Min(value = 1 , message = "plant height cannot be zero")
	private Integer plantHeight;
	
	@NotBlank
	private String plantSpread;
	
	@NotBlank
	private String commonName;
	
	@NotBlank
	private String bloomTime;
	
	@NotBlank
	private String medicinalOrCulinaryUse;
	
	@NotBlank
	private String difficultyLevel;
	
	@NotBlank
	private String temperature;
	
	@NotBlank
	private String typeOfPlant;
	
	@NotBlank
	private String plantDescription;
	
	@Min(value = 0 , message = "plant stock cannot be negative")
	private Integer plantsStock;
	
	@Min(value = 1 , message = "plant cost cannot be zero")
	private double plantCost;
}
