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
	@NotNull
	private Integer userId;
	
	private String name;
	
	private String password;
	
	

}
