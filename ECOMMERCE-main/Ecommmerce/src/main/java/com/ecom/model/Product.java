package com.ecom.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productid;
	private String productname;
	private String productimg;
	private String description;
	private Long Marketprice;
	private Long Saleprice;
	
	@ManyToOne
	@JoinColumn(name="Categoryid", referencedColumnName = "catId")
	private Categorys categorys;

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductimg() {
		return productimg;
	}

	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getMarketprice() {
		return Marketprice;
	}

	public void setMarketprice(Long marketprice) {
		Marketprice = marketprice;
	}

	public Long getSaleprice() {
		return Saleprice;
	}

	public void setSaleprice(Long saleprice) {
		Saleprice = saleprice;
	}

	public Categorys getCategorys() {
		return categorys;
	}

	public void setCategorys(Categorys categorys) {
		this.categorys = categorys;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productimg=" + productimg
				+ ", description=" + description + ", Marketprice=" + Marketprice + ", Saleprice=" + Saleprice
				+ ", categorys=" + categorys + "]";
	}

	public Product(Integer productid, String productname, String productimg, String description, Long marketprice,
			Long saleprice, Categorys categorys) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productimg = productimg;
		this.description = description;
		Marketprice = marketprice;
		Saleprice = saleprice;
		this.categorys = categorys;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

}
