package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.model.Admin;
import com.ecom.model.Product;
import com.ecom.services.AdminServices;
import com.ecom.services.ProductServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AdminCotroller {
	
	@Autowired
	private AdminServices services;
	
	@Autowired
	private ProductServices Pservices;
	
	@PostMapping("/adminregister")
public ResponseEntity<Admin> RegisterHandler(@RequestBody Admin admin){
	
		Admin data= services.Register(admin);
		return new ResponseEntity<Admin>(data, HttpStatus.CREATED);
	
	
}
	@GetMapping("/index")
	public String GoHome() {
		return "index";
	}

//Product Controller
	
	@PostMapping("/admin.addproduct")
	public ResponseEntity<String> AddProductHandler(@RequestBody Product product){
		
		String data= Pservices.AddProduct(product);
		
		return new ResponseEntity<String>(data, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/admin/getproducts")
	public ResponseEntity<List<Product>> GetAllProduct(){
		List<Product> data= Pservices.GetAllProducts();
		return new ResponseEntity<List<Product>>(data, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/admin/updateproduct")
	public ResponseEntity<String> UpdateProductHandler(@RequestParam Integer id, @RequestBody Product product){
		
		String data=Pservices.UpdateProduct(id, product);
		
		return new ResponseEntity<String>(data, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("admin/deleteproduct")
	public  ResponseEntity<String> DeleteProduct(@RequestParam Integer id){
		
		String data=Pservices.DeleteProduct(id);
		return new ResponseEntity<String>(data, HttpStatus.ACCEPTED);
	}
	
}
