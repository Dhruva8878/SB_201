package com.masai.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
	
	@NotNull(message = "userId is neccessary")
	private Integer userId;
     
	@NotNull(message = "password should not be null")
	@Pattern(regexp = "[A-Za-z0-9]")
	@Size(min = 6,max=12)
	private String password;
	
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	@NotNull(message = "phone is neccessary")
	private String phoneNo;
}
