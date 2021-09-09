package com.example.entity;

public class Product {
	
	private int productid;
	private String productname;
	private String productprice;
	
	public Product() {
		
	}
	
	public Product(int productid, String productname, String productprice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductprice() {
		return productprice;
	}
	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}
	
	
	
}
