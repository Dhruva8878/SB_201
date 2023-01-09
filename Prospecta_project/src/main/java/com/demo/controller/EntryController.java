package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Entry;

@RestController
public class EntryController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/entries")
	public ResponseEntity<Entry> getAllEntryHandler(){
		
		Entry entry = restTemplate.getForObject("https://api.publicapis.org/entries", Entry.class);
		
		return new ResponseEntity<Entry>(entry,HttpStatus.OK);
	}
	
}
