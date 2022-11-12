package com.ecom.model;

public class ProductDto {

	private Integer productid;
	private String productname;
	private String productimg;
	private Long Marketprice;
	private Long Saleprice;
	private Integer Quntity;
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
	public Integer getQuntity() {
		return Quntity;
	}
	public void setQuntity(Integer quntity) {
		Quntity = quntity;
	}
	@Override
	public String toString() {
		return "ProductDto [productid=" + productid + ", productname=" + productname + ", productimg=" + productimg
				+ ", Marketprice=" + Marketprice + ", Saleprice=" + Saleprice + ", Quntity=" + Quntity + "]";
	}
	
}
