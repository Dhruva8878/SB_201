package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@Entity
public class Entry {
	
	@JoinColumn(name = "API")
	private String api;
	
	@JoinColumn(name = "Description")
	private String description;
     
	@JoinColumn(name = "Auth")
	private String auth;
	
	@JoinColumn(name = "HTTPS")
	private Boolean https;
	
	@JoinColumn(name = "Cors")
	private String cors;
	
	@JoinColumn(name =  "Link")
	private String link;
	
	@JoinColumn(name = "Category")
	private String category;
}
