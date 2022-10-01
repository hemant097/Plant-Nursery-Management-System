package com.masai.models;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	@NotBlank(message = "mobile number field should not be empty!")
	@Pattern(regexp = "[789]{1}[0-9]{9}",message ="Please enter a valid 10 "
			+ "digit mobile number starting with 7/8/9 ")
	private String mobile;
	
	@NotBlank(message = "Password field should not be empty")
	private String password;
}
