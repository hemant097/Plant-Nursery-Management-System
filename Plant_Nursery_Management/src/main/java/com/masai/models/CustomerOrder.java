package com.masai.models;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingOrderId;
	
	private LocalDate orderDate;
	private String transactionMode;
	private Integer quantity;
	private Double totalCost;
	private Integer customerId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Planter> planters;

}
