package com.masai.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
	
	@NotBlank
	private String houseNo;
	
	@NotBlank
	private String colony;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@Pattern(regexp = "[1-9]{1}[0-9]{5}",message = " Please enter a"
			+ " valid 6 digit pincode ")
	private Integer pinCode;
	

}
