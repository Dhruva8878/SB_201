package com.log.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {
	
	@Id
	@NotNull(message = "userId Is mandatory to search the status")
	private Integer userId;
	
	@NotNull(message = "this field is mandatory")
	private String name;
	
	@NotNull(message = "this field is mandatory")
	private String password;
	
	

}
