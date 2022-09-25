package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;
import com.masai.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService prs;
	
	@PostMapping("/product")
	public ResponseEntity<Product> registerHandler(@RequestBody Product p) throws ProductException{
		
		Product pr= prs.registerProduct(p);
		
		return new ResponseEntity<Product>(pr,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllHandler() throws ProductException{
		
		List<Product> products=prs.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PutMapping("/products")
	public ResponseEntity<Product> updateHandler(@RequestBody Product p) throws ProductException{
		
		Product pr= prs.updateProdcut(p);
		
		return new ResponseEntity<Product>(pr,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteHandler(@PathVariable("id") Integer Id) throws ProductException{
		
		Product pr= prs.deleteProductById(Id);
		
		return new  ResponseEntity<Product>(pr,HttpStatus.OK);
		
	}
	
	@GetMapping("/products/{cat}")
	public ResponseEntity<List<Product>> getCatogoryHandler(@PathVariable("cat") String cat) throws ProductException{
		
		List<Product> list=prs.getsProductByCategory(cat);
		
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/productsDTO")
	public ResponseEntity<List<ProductDTO>> getspecificHandler() throws ProductException{
		
		List<ProductDTO> pdto=prs.getProductNameQtyPrice();
		
		return new ResponseEntity<List<ProductDTO>>(pdto,HttpStatus.OK);
		
	}

}
