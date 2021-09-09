package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	int insertProduct(Product product);
	int updateProduct( String productname, String productprice, int productid);
	int deleteProduct(int productid);

}
