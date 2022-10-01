package com.masai.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank(message = "Name field should not be empty")
	private String name;
	
	@NotBlank(message = "Please Enter your Mobile Number")
	@Pattern(regexp = "[789]{1}[0-9]{9}",message = " Please enter a"
			+ " valid 10 digit mobile number starting with 7/8/9 ")
	private String mobile;
	
	@NotBlank(message = "Password is a mandatory field")
	private String password;              
}
