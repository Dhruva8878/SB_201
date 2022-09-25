package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.ProductException;
import com.masai.model.Product;
import com.masai.model.ProductDTO;
import com.masai.repo.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	public ProductDAO pro;

	@Override
	public Product registerProduct(Product p) throws ProductException {
		
		Product product= pro.save(p);
		
		return product;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		
		List<Product> products= pro.findAll();
		if(products.size()>0) {
			return products;
		}
		else {
			throw new ProductException("No Product Exist");
		}
	}

	@Override
	public Product updateProdcut(Product p) throws ProductException {
		
		Optional<Product> product= pro.findById(p.getProductId());
		
		if(product.isPresent()) {
			return pro.save(product.get()); 
		}
		else {
			throw new ProductException("Wrong Credentials");
		}
	}

	@Override
	public Product deleteProductById(Integer pid) throws ProductException {
       
		Optional<Product> product= pro.findById(pid);
		
		if(product.isPresent()) {
			pro.delete(product.get());
			
			return product.get();
		}
		else {
			throw new ProductException("Wrong Credentials");
		}
		
	}

	@Override
	public List<Product> getsProductByCategory(String category) throws ProductException {
		
		 List<Product> products= pro.findByCatogory(category);
		 
		 if(products.size()>0) {
			 return products;
		 }
		 else {
			 throw new ProductException("Catogory Not Exist :"+category);
		 }
	}

	@Override
	public List<ProductDTO> getProductNameQtyPrice() throws ProductException {
		
		List<Product> products=pro.findAll();
		
		if(products.size()>0) {
			List<ProductDTO> pdt=new ArrayList<>();
			
			for(Product pr:products) {
			 pdt.add(new ProductDTO(pr.getProductName(), pr.getQuantity(),
					 pr.getPrice()));
			 }
			
			return pdt;
		}
		else {
			throw new ProductException("No Products are Available In List");
		}
		
	}
	
	
	

}
