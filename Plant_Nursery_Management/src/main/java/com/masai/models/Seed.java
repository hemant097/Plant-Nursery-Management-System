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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer seedId;
	
	@NotBlank
	private String commonName;
	
	@NotBlank
	private String bloomTime;
	
	@NotBlank
	private String watering;
	
	@NotBlank
	private String difficultyLevel;
	
	@NotBlank
	private String temperature;
	
	@NotBlank
	private String typeOfSeeds;
	
	@NotBlank
	private String seedsDescription;
	
	@Min(value = 0, message = "Seed's stock can't be negative")
	private Integer seedsStock;
	
	@Min(value = 1, message = "Seed's cost should not be zero")
	private Double seedsCost;
	
	@Min(value = 1, message = "There cannot be zero seeds in a packet")
	private Integer seedsPerPacket;
	
	
	
}
