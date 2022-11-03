package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Tag;
import com.masai.service.TagService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TagController {
	
	@Autowired
	private TagService tagServ;
	
	@PostMapping("tag/add")
	public ResponseEntity<Tag> saveTagHandler(@RequestBody Tag tag){
		Tag saveTag = tagServ.createTag(tag);
		
		return new ResponseEntity<Tag>(saveTag, HttpStatus.CREATED);
	}
}
