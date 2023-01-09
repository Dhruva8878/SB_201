package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Entry;

@RestController
public class EntryController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<Entry>> getAllEntryHandler(@RequestParam("category") String category){
			
		ResponseEntity<List> forEntity = restTemplate.getForEntity("https://api.publicapis.org/entries", List.class);
		
		List<Entry> entries = forEntity.getBody();
		
		List<Entry> cateList =new ArrayList<>();
		
		for(Entry e: entries) {
			if(e.getCategory().contains(category)) {
				cateList.add(e);
			}
			else {
				continue;
			}
		}
		
		
		
		return new ResponseEntity<List<Entry>>(cateList, HttpStatus.OK);
	}
	
	@PostMapping("/entry")
	 public ResponseEntity<List<Entry>> postEntryHandler(Entry entry)
	    {    
		restTemplate.postForEntity(
	            "https://api.publicapis.org/entries", entry,
	            Entry.class, HttpStatus.CREATED);
		    
     ResponseEntity<List> forEntity = restTemplate.getForEntity("https://api.publicapis.org/entries", List.class);
		
		List<Entry> entries = forEntity.getBody();
		
	        return new ResponseEntity<List<Entry>>(entries,HttpStatus.OK);
	    }
	
}
