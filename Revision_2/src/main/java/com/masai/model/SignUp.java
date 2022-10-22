package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUp {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotNull(message = "name is neccessary")
	private  String userName;
	
	@Email
	@NotNull(message = "email is neccessary")
	private String email; 
	
	@Pattern(regexp = "[6-9]{1}[0-9]{9}")
	@NotNull(message = "phone is neccessary")
	private String phoneNo;
	
	@NotNull(message = "password should not be null")
	@Pattern(regexp = "[A-Za-z0-9]")
	@Size(min = 6,max=12)
	private String password;
	
}
