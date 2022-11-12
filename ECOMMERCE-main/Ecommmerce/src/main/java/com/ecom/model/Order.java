package com.ecom.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Order {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderid;
	
	private Long Total_Amount;
	private Integer userid;
	private String status;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Long getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(Long total_Amount) {
		Total_Amount = total_Amount;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
