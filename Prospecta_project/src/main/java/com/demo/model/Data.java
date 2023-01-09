package com.demo.model;

import java.util.ArrayList;
import java.util.List;

@lombok.Data
public class Data {
	
	private Integer count;
	
	private List<Entry> entries = new ArrayList<>();

}
