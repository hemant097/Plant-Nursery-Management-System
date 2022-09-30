package com.masai.models;
import javax.validation.constraints.NotNull;
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
	
	@NotNull(message = "mobile number field should not be empty!")
	@Pattern(regexp = "[789]{1}[0-9]{9}",message ="Please enter 10 digit mobile ")
	private String mobile;
	
	@NotNull(message = "Password field should not be empty")
	private Integer password;
}
