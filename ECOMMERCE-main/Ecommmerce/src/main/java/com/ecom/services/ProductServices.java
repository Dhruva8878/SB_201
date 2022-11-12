package com.ecom.services;

import java.util.List;
import com.ecom.model.Product;

public interface ProductServices {
	
	public String AddProduct(Product product);
	public List<Product> GetAllProducts();
	public String UpdateProduct(Integer id, Product product);
	public String DeleteProduct(Integer id);
	
	
	
}
