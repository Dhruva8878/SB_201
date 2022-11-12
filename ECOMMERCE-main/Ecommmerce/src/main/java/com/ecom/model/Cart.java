package com.ecom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartid;
	
	@OneToOne(mappedBy = "userid")
	private User user;
	
	@ManyToOne
	private List<ProductDto> product=new ArrayList<ProductDto>();

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductDto> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDto> product) {
		this.product = product;
	}
	
	

}
