package com.ecom.services;

import java.util.List;

import com.ecom.model.Categorys;

public interface CategoryServices {
	
	public Categorys AddCategory(Categorys cat);
	public String DeleteCategory(Integer id);
	public Categorys UpdatedCategory(Integer id, Categorys cat);
	public List<Categorys> AllCategorys();

}
