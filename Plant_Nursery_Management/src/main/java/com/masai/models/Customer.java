package com.masai.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer customerId;
	
	@NotNull(message = "Name field should not be empty")
	@Pattern(regexp = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$",message = "please enter a valid name")
	private String name;
	
	@NotNull(message = "Mobile number field should not be empty")
	@Pattern(regexp = "[7896]{1}[0-9]{9}",message = "Input a valid mobile number")
	private String mobile;
	
	@NotNull(message="Email is mandatory")
	@Pattern(regexp = "^(.+)@(\\S+)$",message = "Input a valid email address")
	private String email;
	
	@Embedded
	private Address address;
	
}
