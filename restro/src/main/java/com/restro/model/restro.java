package com.restro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class restro {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column(nullable=false)
    private String productName;
    @Column(nullable=false)
    private String productDesc;
    @Column(nullable=false)
    private double productPrice;
    @Column(nullable=false)
    private String productImg;
    
    
    // default constructor
	public restro() {
		super();
	}


	public restro(int productId, String productName, String productDesc, double productPrice, String productImg) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productImg = productImg;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductImg() {
		return productImg;
	}


	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}


	@Override
	public String toString() {
		return "restro [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + ", productImg=" + productImg + "]";
	}

	
}
