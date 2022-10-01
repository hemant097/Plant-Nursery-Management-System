package com.masai.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
	
	
	private String houseNo;
	private String colony;
	
	private String city;
	private String state;
	private Integer pinCode;
	

}
